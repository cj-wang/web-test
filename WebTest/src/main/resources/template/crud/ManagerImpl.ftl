package ${packageName}.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.walle.framework.core.service.impl.BaseManagerImpl;

import ${packageName}.model.${className}Model;
import ${packageName}.service.${className}Manager;

@Service
public class ${className}ManagerImpl extends BaseManagerImpl implements ${className}Manager {

	@Override
	public ${className}Model save(${className}Model model) {
		return this.dao.save(model);
	}

	@Override
	public List<${className}Model> saveAll(Collection<${className}Model> models) {
		return this.dao.saveAll(models);
	}

	@Override
	public List<${className}Model> saveTreeData(Collection<${className}Model> models, String idField, String parentField) {
		return this.dao.saveTreeData(models, idField, parentField);
	}

	@Override
	public void remove(${className}Model model) {
		this.dao.remove(model);
	}

	@Override
	public void removeAll(Collection<${className}Model> models) {
		this.dao.removeAll(models);
	}

}
