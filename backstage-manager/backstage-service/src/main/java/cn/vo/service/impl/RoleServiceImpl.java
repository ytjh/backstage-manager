package cn.vo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vo.dao.RoleMapper;
import cn.vo.pojo.Role;
import cn.vo.pojo.RoleExample;
import cn.vo.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public Integer count() {
		RoleExample example=new RoleExample();
		return roleMapper.countByExample(example);
	}

	@Override
	public List<Role> getListQuery(Map map) {
		return roleMapper.getListQuery(map);
	}

	@Override
	public Role getById(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insert(Role role) {
		roleMapper.insertSelective(role);
		
	}

	@Override
	public void update(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public void delId(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
		
	}

}
