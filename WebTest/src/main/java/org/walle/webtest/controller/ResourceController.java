package org.walle.webtest.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	/**
	 * query
	 * @param tableName
	 * @return
	 */
	@RequestMapping(value="/api/walle/table/{tableName}", method=RequestMethod.GET)
	public ResponseEntity<Object> query(@PathVariable String tableName, @RequestParam(required=false) String orderBy) {
		Class<? extends BaseModel> modelClass = null;
		try {
			modelClass = EntityUtils.getEntityClass(SqlUtils.dbNameToJavaName(tableName, true));
		} catch (Exception e) {
		}
		if (modelClass == null) {
			return new ResponseEntity<Object>("Table " + tableName + " does not exists", HttpStatus.BAD_REQUEST);
		}
		QueryInfo queryInfo = new QueryInfo(modelClass);
		queryInfo.setOrderBy(orderBy);
		QueryData queryData = commonQueryManager.query(queryInfo);
		return new ResponseEntity<Object>(queryData.getDataList(modelClass), HttpStatus.OK);
	}
	
	/**
	 * get
	 * @param tableName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/api/walle/table/{tableName}/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable String tableName, @PathVariable String id) {
		Class<? extends BaseModel> modelClass = null;
		try {
			modelClass = EntityUtils.getEntityClass(SqlUtils.dbNameToJavaName(tableName, true));
		} catch (Exception e) {
		}
		if (modelClass == null) {
			return new ResponseEntity<Object>("Table " + tableName + " does not exists", HttpStatus.BAD_REQUEST);
		}
		QueryInfo queryInfo = new QueryInfo(modelClass, new QueryField(EntityUtils.getIdFieldName(modelClass), id));
		QueryData queryData = commonQueryManager.query(queryInfo);
		if (queryData.getDataList().size() == 1) {
			return new ResponseEntity<Object>(queryData.getDataList(modelClass).get(0), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Object not found", HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * save
	 * @param tableName
	 * @param dynamicModel
	 * @return
	 */
	@RequestMapping(value="/api/walle/table/{tableName}", method={RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<Object> save(@PathVariable String tableName, @RequestBody DynamicModelClass dynamicModel) {
		Class<? extends BaseModel> modelClass = null;
		try {
			modelClass = EntityUtils.getEntityClass(SqlUtils.dbNameToJavaName(tableName, true));
		} catch (Exception e) {
		}
		if (modelClass == null) {
			return new ResponseEntity<Object>("Table " + tableName + " does not exists", HttpStatus.BAD_REQUEST);
		}
		try {
			BaseModel model = modelClass.newInstance();
			BeanUtils.populate(model, dynamicModel);
			CommonSaveManager<BaseModel> commonSaveManager = ContextUtils.getBean(SqlUtils.dbNameToJavaName(tableName, false) + "Manager", CommonSaveManager.class);
			model = commonSaveManager.save(model);
			return new ResponseEntity<Object>(model, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * delete
	 * @param tableName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/api/walle/table/{tableName}/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable String tableName, @PathVariable String id) {
		Class<? extends BaseModel> modelClass = null;
		try {
			modelClass = EntityUtils.getEntityClass(SqlUtils.dbNameToJavaName(tableName, true));
		} catch (Exception e) {
		}
		if (modelClass == null) {
			return new ResponseEntity<Object>("Table " + tableName + " does not exists", HttpStatus.BAD_REQUEST);
		}
		QueryInfo queryInfo = new QueryInfo(modelClass, new QueryField(EntityUtils.getIdFieldName(modelClass), id));
		QueryData queryData = commonQueryManager.query(queryInfo);
		if (queryData.getDataList().size() == 1) {
			try {
				CommonSaveManager<BaseModel> commonSaveManager = ContextUtils.getBean(SqlUtils.dbNameToJavaName(tableName, false) + "Manager", CommonSaveManager.class);
				commonSaveManager.remove(queryData.getDataList(modelClass).get(0));
				return new ResponseEntity<Object>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<Object>("Object not found", HttpStatus.NOT_FOUND);
		}
	}
	
}
