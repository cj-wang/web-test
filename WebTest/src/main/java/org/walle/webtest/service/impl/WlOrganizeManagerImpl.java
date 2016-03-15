package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;
import org.walle.webtest.model.WlOrganizeModel;
import org.walle.webtest.service.WlOrganizeManager;

@Service
public class WlOrganizeManagerImpl extends BaseManagerImpl implements WlOrganizeManager {

	public List<WlOrganizeModel> saveAll(Collection<WlOrganizeModel> models) {
		return this.dao.saveAll(models);
	}

}
