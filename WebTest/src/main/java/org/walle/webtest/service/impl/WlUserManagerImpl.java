package org.walle.webtest.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;
import org.walle.webtest.model.WlUserModel;
import org.walle.webtest.service.WlUserManager;

@Service
public class WlUserManagerImpl extends BaseManagerImpl implements WlUserManager {

	public List<WlUserModel> saveAll(Collection<WlUserModel> models) {
		return this.dao.saveAll(models);
	}

}
