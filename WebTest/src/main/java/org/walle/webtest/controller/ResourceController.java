package org.walle.webtest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import cn.walle.framework.common.service.CommonQueryManager;
import cn.walle.framework.common.service.CommonSaveManager;
import cn.walle.framework.common.support.QueryData;
import cn.walle.framework.common.support.QueryField;
import cn.walle.framework.common.support.QueryInfo;
import cn.walle.framework.core.model.BaseModel;
import cn.walle.framework.core.model.DynamicModelClass;
import cn.walle.framework.core.util.ContextUtils;
import cn.walle.framework.core.util.EntityUtils;
import cn.walle.framework.core.util.SqlUtils;

/**
 * REST Controller for Resources
 * @author Changjiang.Wang
 *
 */
@RestController
public class ResourceController {
	
	@Autowired
	private CommonQueryManager commonQueryManager;
	
	@ExceptionHandler(DataRetrievalFailureException.class)
	public void notFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
	
	/**
	 * query
	 * @param tableName
	 * @return
	 */
	@RequestMapping(value="/api/walle/table/{tableName}", method=RequestMethod.GET)
	public List<? extends BaseModel> query(@PathVariable String tableName, @RequestParam(required=false) String orderBy) {
		Class<? extends BaseModel> modelClass = getModelClass(tableName);
		QueryInfo queryInfo = new QueryInfo(modelClass);
		queryInfo.setOrderBy(orderBy);
		QueryData queryData = commonQueryManager.query(queryInfo);
		return queryData.getDataList(modelClass);
	}
	
	/**
	 * get
	 * @param tableName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/api/walle/table/{tableName}/{id}", method=RequestMethod.GET)
	public BaseModel get(@PathVariable String tableName, @PathVariable String id) {
		Class<? extends BaseModel> modelClass = getModelClass(tableName);
		QueryInfo queryInfo = new QueryInfo(modelClass, new QueryField(EntityUtils.getIdFieldName(modelClass), id));
		QueryData queryData = commonQueryManager.query(queryInfo);
		if (queryData.getDataList().size() == 1) {
			return queryData.getDataList(modelClass).get(0);
		} else {
			throw new ObjectRetrievalFailureException(modelClass, id);
		}
	}
	
	/**
	 * save
	 * @param tableName
	 * @param dynamicModel
	 * @return
	 */
	@RequestMapping(value="/api/walle/table/{tableName}", method={RequestMethod.POST, RequestMethod.PUT})
	public BaseModel save(@PathVariable String tableName, @RequestBody DynamicModelClass dynamicModel) {
		Class<? extends BaseModel> modelClass = getModelClass(tableName);
		try {
			BaseModel model = modelClass.newInstance();
			BeanUtils.populate(model, dynamicModel);
			CommonSaveManager<BaseModel> commonSaveManager = ContextUtils.getBean(SqlUtils.dbNameToJavaName(tableName, false) + "Manager", CommonSaveManager.class);
			return commonSaveManager.save(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * delete
	 * @param tableName
	 * @param id
	 * @return
	 * @throws NoSuchRequestHandlingMethodException 
	 */
	@RequestMapping(value="/api/walle/table/{tableName}/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String tableName, @PathVariable String id) {
		Class<? extends BaseModel> modelClass = getModelClass(tableName);
		QueryInfo queryInfo = new QueryInfo(modelClass, new QueryField(EntityUtils.getIdFieldName(modelClass), id));
		QueryData queryData = commonQueryManager.query(queryInfo);
		if (queryData.getDataList().size() == 1) {
			try {
				CommonSaveManager<BaseModel> commonSaveManager = ContextUtils.getBean(SqlUtils.dbNameToJavaName(tableName, false) + "Manager", CommonSaveManager.class);
				commonSaveManager.remove(queryData.getDataList(modelClass).get(0));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new ObjectRetrievalFailureException(modelClass, id);
		}
	}
	
	private Class<? extends BaseModel> getModelClass(String tableName) {
		Class<? extends BaseModel> modelClass = null;
		try {
			modelClass = EntityUtils.getEntityClass(SqlUtils.dbNameToJavaName(tableName, true));
		} catch (Exception e) {
		}
		if (modelClass != null) {
			return modelClass;
		} else {
			throw new DataRetrievalFailureException("Table " + tableName + " not found");
		}
	}
	
}
