package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlOrganizeModel;
import org.walle.webtest.service.WlOrganizeManager;

@Service
public class WlOrganizeManagerImpl extends BaseManagerImpl implements WlOrganizeManager {

	@Override
	public WlOrganizeModel save(WlOrganizeModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlOrganizeModel> saveAll(Collection<WlOrganizeModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlOrganizeModel> saveTreeData(Collection<WlOrganizeModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlOrganizeModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlOrganizeModel> models) {
		this.dao.removeAll(models);
	}

}
