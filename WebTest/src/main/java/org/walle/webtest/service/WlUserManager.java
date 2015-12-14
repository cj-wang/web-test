package org.walle.webtest.service;

import java.util.Collection;
import java.util.List;

import cn.walle.framework.core.service.BaseManager;
import org.walle.webtest.model.WlUserModel;

public interface WlUserManager extends BaseManager {

	List<WlUserModel> saveAll(Collection<WlUserModel> models);

}
