package cn.vo.service;

import java.util.List;

import cn.vo.pojo.RoleModule;

public interface IRoleModuleService {
	
	
	List<RoleModule> getRoleId(Integer roleId);
	
	List<RoleModule> getModuleId(Integer moduleId);
	
	void insert(RoleModule roleModule);
	
	void update(RoleModule roleModule);
	
	void delId(Integer id);
	
	void getById(Integer id);
	
	

}
