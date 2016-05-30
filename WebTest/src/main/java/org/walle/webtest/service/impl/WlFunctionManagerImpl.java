package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlFunctionModel;
import org.walle.webtest.service.WlFunctionManager;

@Service
public class WlFunctionManagerImpl extends BaseManagerImpl implements WlFunctionManager {

	@Override
	public WlFunctionModel save(WlFunctionModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlFunctionModel> saveAll(Collection<WlFunctionModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlFunctionModel> saveTreeData(Collection<WlFunctionModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlFunctionModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlFunctionModel> models) {
		this.dao.removeAll(models);
	}

}
