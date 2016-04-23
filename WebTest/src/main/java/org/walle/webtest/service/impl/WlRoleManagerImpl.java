package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlRoleModel;
import org.walle.webtest.service.WlRoleManager;

@Service
public class WlRoleManagerImpl extends BaseManagerImpl implements WlRoleManager {

	@Override
	public WlRoleModel save(WlRoleModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlRoleModel> saveAll(Collection<WlRoleModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlRoleModel> saveTreeData(Collection<WlRoleModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlRoleModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlRoleModel> models) {
		this.dao.removeAll(models);
	}

}
