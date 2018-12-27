package cn.vo.service;

import java.util.List;
import java.util.Map;

import cn.vo.pojo.Module;

public interface IModuleService {
	
	List<Module> getByUserId(Integer userId);
	
	Module getById(Integer id);
	
	List<Module> getListQuery(Map map);
	
	void update(Module module);
	
	void delId(Integer id);
	
	void insert(Module module);
	
	Integer count();
	
	List<Module> getAll(Map map);

	
}
