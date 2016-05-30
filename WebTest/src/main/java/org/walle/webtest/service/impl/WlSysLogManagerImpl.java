package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlSysLogModel;
import org.walle.webtest.service.WlSysLogManager;

@Service
public class WlSysLogManagerImpl extends BaseManagerImpl implements WlSysLogManager {

	@Override
	public WlSysLogModel save(WlSysLogModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlSysLogModel> saveAll(Collection<WlSysLogModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlSysLogModel> saveTreeData(Collection<WlSysLogModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlSysLogModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlSysLogModel> models) {
		this.dao.removeAll(models);
	}

}
