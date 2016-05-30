package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlUserFuncModel;
import org.walle.webtest.service.WlUserFuncManager;

@Service
public class WlUserFuncManagerImpl extends BaseManagerImpl implements WlUserFuncManager {

	@Override
	public WlUserFuncModel save(WlUserFuncModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlUserFuncModel> saveAll(Collection<WlUserFuncModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlUserFuncModel> saveTreeData(Collection<WlUserFuncModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlUserFuncModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlUserFuncModel> models) {
		this.dao.removeAll(models);
	}

}
