package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlUserLoginLogModel;
import org.walle.webtest.service.WlUserLoginLogManager;

@Service
public class WlUserLoginLogManagerImpl extends BaseManagerImpl implements WlUserLoginLogManager {

	@Override
	public WlUserLoginLogModel save(WlUserLoginLogModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlUserLoginLogModel> saveAll(Collection<WlUserLoginLogModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlUserLoginLogModel> saveTreeData(Collection<WlUserLoginLogModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlUserLoginLogModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlUserLoginLogModel> models) {
		this.dao.removeAll(models);
	}

}
