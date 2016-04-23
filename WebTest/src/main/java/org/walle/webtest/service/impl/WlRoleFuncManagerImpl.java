package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import org.walle.webtest.model.WlRoleFuncModel;
import org.walle.webtest.service.WlRoleFuncManager;

@Service
public class WlRoleFuncManagerImpl extends BaseManagerImpl implements WlRoleFuncManager {

	@Override
	public WlRoleFuncModel save(WlRoleFuncModel model) {
		return this.dao.save(model);
	}

	@Override
	public List<WlRoleFuncModel> saveAll(Collection<WlRoleFuncModel> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<WlRoleFuncModel> saveTreeData(Collection<WlRoleFuncModel> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(WlRoleFuncModel model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<WlRoleFuncModel> models) {
		this.dao.removeAll(models);
	}

}
