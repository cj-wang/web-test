package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlUserModel;
import org.walle.webtest.service.WlUserManager;

@Service
public class WlUserManagerImpl extends BaseManagerImpl implements WlUserManager {

	@Override
	public WlUserModel save(WlUserModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlUserModel> saveAll(Collection<WlUserModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlUserModel> saveTreeData(Collection<WlUserModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlUserModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlUserModel> models) {
		this.dao.removeAll(models);
	}

}
