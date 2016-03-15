package org.walle.webtest.service;

import java.util.Collection;
import java.util.List;

import cn.walle.framework.core.service.BaseManager;
import org.walle.webtest.model.WlOrganizeModel;

public interface WlOrganizeManager extends BaseManager {

	List<WlOrganizeModel> saveAll(Collection<WlOrganizeModel> models);

}
