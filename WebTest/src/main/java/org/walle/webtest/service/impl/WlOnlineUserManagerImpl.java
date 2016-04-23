package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlOnlineUserModel;
import org.walle.webtest.service.WlOnlineUserManager;

@Service
public class WlOnlineUserManagerImpl extends BaseManagerImpl implements WlOnlineUserManager {

	@Override
	public WlOnlineUserModel save(WlOnlineUserModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlOnlineUserModel> saveAll(Collection<WlOnlineUserModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlOnlineUserModel> saveTreeData(Collection<WlOnlineUserModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlOnlineUserModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlOnlineUserModel> models) {
		this.dao.removeAll(models);
	}

}
