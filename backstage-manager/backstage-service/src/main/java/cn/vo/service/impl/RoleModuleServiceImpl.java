package cn.vo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vo.dao.RoleModuleMapper;
import cn.vo.pojo.RoleModule;
import cn.vo.pojo.RoleModuleExample;
import cn.vo.pojo.RoleModuleExample.Criteria;
import cn.vo.service.IRoleModuleService;


@Service
public class RoleModuleServiceImpl implements IRoleModuleService{

	
	@Autowired
	private RoleModuleMapper roleModuleMapper;
	
	@Override
	public List<RoleModule> getRoleId(Integer roleId) {
		RoleModuleExample example=new RoleModuleExample();
		Criteria criteria=example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<RoleModule> list=roleModuleMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<RoleModule> getModuleId(Integer moduleId) {
		RoleModuleExample example=new RoleModuleExample();
		Criteria criteria=example.createCriteria();
		criteria.andMIdEqualTo(moduleId);
		List<RoleModule> list=roleModuleMapper.selectByExample(example);
		return list;
	}

	@Override
	public void insert(RoleModule roleModule) {
		roleModuleMapper.insertSelective(roleModule);
		
	}

	@Override
	public void update(RoleModule roleModule) {
		roleModuleMapper.updateByPrimaryKey(roleModule);
		
	}

	@Override
	public void delId(Integer id) {
		roleModuleMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void getById(Integer id) {
		roleModuleMapper.selectByPrimaryKey(id);
	}

}
