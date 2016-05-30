package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlPortalPortletModel;
import org.walle.webtest.service.WlPortalPortletManager;

@Service
public class WlPortalPortletManagerImpl extends BaseManagerImpl implements WlPortalPortletManager {

	@Override
	public WlPortalPortletModel save(WlPortalPortletModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlPortalPortletModel> saveAll(Collection<WlPortalPortletModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlPortalPortletModel> saveTreeData(Collection<WlPortalPortletModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlPortalPortletModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlPortalPortletModel> models) {
		this.dao.removeAll(models);
	}

}
