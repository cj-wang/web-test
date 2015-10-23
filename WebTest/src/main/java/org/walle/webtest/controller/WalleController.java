package org.walle.webtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.walle.framework.common.service.SelectCodeManager;
import cn.walle.framework.common.support.QueryInfo;
import cn.walle.framework.common.support.SelectCodeData;

/**
 * REST Controller for Walle Services
 * -- Walle Framework --
 * @author Changjiang.Wang
 *
 */
@RestController
public class WalleController {
	
	@Autowired
	private SelectCodeManager selectCodeManager;
	
	@RequestMapping("/selectCode/{codeType}")
	public SelectCodeData selectCode(@PathVariable String codeType) {
		QueryInfo queryInfo = new QueryInfo();
		queryInfo.setQueryType(codeType);
		return selectCodeManager.getSelectCodeData(queryInfo);
	}
	
}
