package org.walle.webtest.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.walle.framework.common.service.CommonQueryManager;
import cn.walle.framework.common.service.SelectCodeManager;
import cn.walle.framework.common.support.QueryData;
import cn.walle.framework.common.support.QueryField;
import cn.walle.framework.common.support.QueryInfo;
import cn.walle.framework.common.support.SelectCodeData;
import cn.walle.framework.common.support.SelectCodeDefinition;
import cn.walle.framework.core.support.PagingInfo;

/**
 * REST Controller for Walle Services
 * -- Walle Framework --
 * @author Changjiang.Wang
 *
 */
@RestController
public class WalleController {
	
	@Autowired
	private CommonQueryManager commonQueryManager;
	
	@Autowired
	private SelectCodeManager selectCodeManager;
	
	
	@RequestMapping("/api/walle/commonQuery")
	public QueryData commonQuery(@RequestBody QueryInfo queryInfo) {
		return commonQueryManager.query(queryInfo);
	}
	
	@RequestMapping("/api/walle/selectCode/{codeType}")
	public SelectCodeData selectCode(@PathVariable String codeType) {
		QueryInfo queryInfo = new QueryInfo();
		queryInfo.setQueryType(codeType);
		return selectCodeManager.getSelectCodeData(queryInfo);
	}
	
	@RequestMapping(value="/api/walle/selectCode/{codeType}", params="q")
	public SelectCodeData selectCode(@PathVariable String codeType, @RequestParam String q, @RequestParam(required=false) Integer limit) {
		SelectCodeDefinition selectCodeDefinition = selectCodeManager.getSelectCodeDefinition(codeType);
		Set<String> fieldNames = new HashSet<String>();
		fieldNames.add(selectCodeDefinition.getKeyFieldName());
		fieldNames.add(selectCodeDefinition.getLabelFieldName());
		if (selectCodeDefinition.getColumns() != null) {
			for (Map<String, String> column : selectCodeDefinition.getColumns()) {
				fieldNames.add(column.get("field"));
			}
		}
		
		QueryInfo queryInfo = new QueryInfo();
		queryInfo.setQueryType(codeType);
		queryInfo.setQueryFields(Arrays.asList(
				new QueryField("[" + StringUtils.collectionToCommaDelimitedString(fieldNames) + "]", "ilikeAnywhere", q)));
		if (limit != null && limit >= 0) {
			queryInfo.setPagingInfo(new PagingInfo(limit, 0));
		}
		return selectCodeManager.getSelectCodeData(queryInfo);
	}
	
}
