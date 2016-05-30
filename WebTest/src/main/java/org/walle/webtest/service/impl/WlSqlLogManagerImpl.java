package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlSqlLogModel;
import org.walle.webtest.service.WlSqlLogManager;

@Service
public class WlSqlLogManagerImpl extends BaseManagerImpl implements WlSqlLogManager {

	@Override
	public WlSqlLogModel save(WlSqlLogModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlSqlLogModel> saveAll(Collection<WlSqlLogModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlSqlLogModel> saveTreeData(Collection<WlSqlLogModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlSqlLogModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlSqlLogModel> models) {
		this.dao.removeAll(models);
	}

}
