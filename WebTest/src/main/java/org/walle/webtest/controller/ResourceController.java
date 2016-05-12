package org.walle.webtest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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
import cn.walle.framework.core.support.PagingInfo;
import cn.walle.framework.core.util.ContextUtils;
import cn.walle.framework.core.util.EntityUtils;
import cn.walle.framework.core.util.SqlUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * REST Controller for Resources
 * @author Changjiang.Wang
 *
 */
@RestController
public class ResourceController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CommonQueryManager commonQueryManager;
	
	@ExceptionHandler(DataRetrievalFailureException.class)
	public void notFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
	
	/**
	 * query
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/resource/{name}", method=RequestMethod.GET)
	public List<? extends BaseModel> query(@PathVariable String name, @RequestParam Map<String, String> params) {
		Class<? extends BaseModel> modelClass = getModelClass(name);
		QueryInfo queryInfo = new QueryInfo(modelClass);
		queryInfo.setOrderBy(params.remove("orderBy"));
		if (params.containsKey("pageSize")) {
			PagingInfo pagingInfo = new PagingInfo();
			pagingInfo.setPageSize(Integer.valueOf(params.remove("pageSize")));
			if (params.containsKey("currentPage")) {
				pagingInfo.setCurrentPage(Integer.valueOf(params.remove("currentPage")));
			}
			queryInfo.setPagingInfo(pagingInfo);
		}
		queryInfo.setQueryFields(new ArrayList<QueryField>());
		for (String paramKey : params.keySet()) {
			queryInfo.getQueryFields().add(new QueryField(paramKey, params.get(paramKey)));
		}
		QueryData queryData = commonQueryManager.query(queryInfo);
		return queryData.getDataList(modelClass);
	}
	
	/**
	 * get
	 * @param name
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/resource/{name}/{id}", method=RequestMethod.GET)
	public BaseModel get(@PathVariable String name, @PathVariable String id) {
		Class<? extends BaseModel> modelClass = getModelClass(name);
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
	 * @param name
	 * @param httpEntity
	 * @return
	 */
	@RequestMapping(value="/resource/{name}", method={RequestMethod.POST, RequestMethod.PUT})
	public BaseModel save(@PathVariable String name, HttpEntity<String> httpEntity) {
		Class<? extends BaseModel> modelClass = getModelClass(name);
		try {
			BaseModel model = objectMapper.readValue(httpEntity.getBody(), modelClass);
			CommonSaveManager<BaseModel> commonSaveManager = ContextUtils.getBean(SqlUtils.dbNameToJavaName(name, false) + "Manager", CommonSaveManager.class);
			return commonSaveManager.save(model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * save with id
	 * @param name
	 * @param id
	 * @param httpEntity
	 * @return
	 */
	@RequestMapping(value="/resource/{name}/{id}", method={RequestMethod.POST, RequestMethod.PUT})
	public BaseModel save(@PathVariable String name, @PathVariable String id, HttpEntity<String> httpEntity) {
		return save(name, httpEntity);
	}
	
	/**
	 * delete
	 * @param name
	 * @param id
	 * @return
	 * @throws NoSuchRequestHandlingMethodException 
	 */
	@RequestMapping(value="/resource/{name}/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String name, @PathVariable String id) {
		Class<? extends BaseModel> modelClass = getModelClass(name);
		QueryInfo queryInfo = new QueryInfo(modelClass, new QueryField(EntityUtils.getIdFieldName(modelClass), id));
		QueryData queryData = commonQueryManager.query(queryInfo);
		if (queryData.getDataList().size() == 1) {
			try {
				CommonSaveManager<BaseModel> commonSaveManager = ContextUtils.getBean(SqlUtils.dbNameToJavaName(name, false) + "Manager", CommonSaveManager.class);
				commonSaveManager.remove(queryData.getDataList(modelClass).get(0));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new ObjectRetrievalFailureException(modelClass, id);
		}
	}
	
	private Class<? extends BaseModel> getModelClass(String name) {
		Class<? extends BaseModel> modelClass = null;
		try {
			modelClass = EntityUtils.getEntityClass(SqlUtils.dbNameToJavaName(name, true));
		} catch (Exception e) {
		}
		if (modelClass != null) {
			return modelClass;
		} else {
			throw new DataRetrievalFailureException("Resource type " + name + " not found");
		}
	}
	
}
