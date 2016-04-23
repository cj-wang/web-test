package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlPortalMyportletModel;
import org.walle.webtest.service.WlPortalMyportletManager;

@Service
public class WlPortalMyportletManagerImpl extends BaseManagerImpl implements WlPortalMyportletManager {

	@Override
	public WlPortalMyportletModel save(WlPortalMyportletModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlPortalMyportletModel> saveAll(Collection<WlPortalMyportletModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlPortalMyportletModel> saveTreeData(Collection<WlPortalMyportletModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlPortalMyportletModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlPortalMyportletModel> models) {
		this.dao.removeAll(models);
	}

}
