package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlTenantModel;
import org.walle.webtest.service.WlTenantManager;

@Service
public class WlTenantManagerImpl extends BaseManagerImpl implements WlTenantManager {

	@Override
	public WlTenantModel save(WlTenantModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlTenantModel> saveAll(Collection<WlTenantModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlTenantModel> saveTreeData(Collection<WlTenantModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlTenantModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlTenantModel> models) {
		this.dao.removeAll(models);
	}

}
