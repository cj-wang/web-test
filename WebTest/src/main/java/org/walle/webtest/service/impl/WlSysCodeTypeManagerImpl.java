package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlSysCodeTypeModel;
import org.walle.webtest.service.WlSysCodeTypeManager;

@Service
public class WlSysCodeTypeManagerImpl extends BaseManagerImpl implements WlSysCodeTypeManager {

	@Override
	public WlSysCodeTypeModel save(WlSysCodeTypeModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlSysCodeTypeModel> saveAll(Collection<WlSysCodeTypeModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlSysCodeTypeModel> saveTreeData(Collection<WlSysCodeTypeModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlSysCodeTypeModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlSysCodeTypeModel> models) {
		this.dao.removeAll(models);
	}

}
