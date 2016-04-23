package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlUserRoleModel;
import org.walle.webtest.service.WlUserRoleManager;

@Service
public class WlUserRoleManagerImpl extends BaseManagerImpl implements WlUserRoleManager {

	@Override
	public WlUserRoleModel save(WlUserRoleModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlUserRoleModel> saveAll(Collection<WlUserRoleModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlUserRoleModel> saveTreeData(Collection<WlUserRoleModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlUserRoleModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlUserRoleModel> models) {
		this.dao.removeAll(models);
	}

}
