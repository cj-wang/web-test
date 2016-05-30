package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlNotificationModel;
import org.walle.webtest.service.WlNotificationManager;

@Service
public class WlNotificationManagerImpl extends BaseManagerImpl implements WlNotificationManager {

	@Override
	public WlNotificationModel save(WlNotificationModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlNotificationModel> saveAll(Collection<WlNotificationModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlNotificationModel> saveTreeData(Collection<WlNotificationModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlNotificationModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlNotificationModel> models) {
		this.dao.removeAll(models);
	}

}
