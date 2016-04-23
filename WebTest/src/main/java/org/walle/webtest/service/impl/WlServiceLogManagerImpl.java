package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlServiceLogModel;
import org.walle.webtest.service.WlServiceLogManager;

@Service
public class WlServiceLogManagerImpl extends BaseManagerImpl implements WlServiceLogManager {

	@Override
	public WlServiceLogModel save(WlServiceLogModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlServiceLogModel> saveAll(Collection<WlServiceLogModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlServiceLogModel> saveTreeData(Collection<WlServiceLogModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlServiceLogModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlServiceLogModel> models) {
		this.dao.removeAll(models);
	}

}
