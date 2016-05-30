package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlSysCodeModel;
import org.walle.webtest.service.WlSysCodeManager;

@Service
public class WlSysCodeManagerImpl extends BaseManagerImpl implements WlSysCodeManager {

	@Override
	public WlSysCodeModel save(WlSysCodeModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlSysCodeModel> saveAll(Collection<WlSysCodeModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlSysCodeModel> saveTreeData(Collection<WlSysCodeModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlSysCodeModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlSysCodeModel> models) {
		this.dao.removeAll(models);
	}

}
