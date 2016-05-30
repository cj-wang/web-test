package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlPortalRolePortletModel;
import org.walle.webtest.service.WlPortalRolePortletManager;

@Service
public class WlPortalRolePortletManagerImpl extends BaseManagerImpl implements WlPortalRolePortletManager {

	@Override
	public WlPortalRolePortletModel save(WlPortalRolePortletModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlPortalRolePortletModel> saveAll(Collection<WlPortalRolePortletModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlPortalRolePortletModel> saveTreeData(Collection<WlPortalRolePortletModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlPortalRolePortletModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlPortalRolePortletModel> models) {
		this.dao.removeAll(models);
	}

}
