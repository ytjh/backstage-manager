package cn.vo.service;

import java.util.List;
import java.util.Map;

import cn.vo.pojo.Role;

public interface IRoleService {
	
	Integer count();
	List<Role> getListQuery(Map map);
	
	Role getById(Integer id);
	
	void insert(Role role);
	
	void update(Role role);
	
	void delId(Integer id);

}
