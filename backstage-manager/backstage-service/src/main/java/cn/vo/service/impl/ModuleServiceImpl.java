package cn.vo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vo.dao.ModuleMapper;
import cn.vo.pojo.Module;
import cn.vo.pojo.ModuleExample;
import cn.vo.service.IModuleService;

@Service
public class ModuleServiceImpl implements IModuleService {
	
	@Autowired
	private ModuleMapper moduleMapper;

	@Override
	public List<Module> getByUserId(Integer userId) {
		return moduleMapper.getByUserId(userId);
	}

	@Override
	public Module getById(Integer id) {
		return moduleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Module> getListQuery(Map map) {
		return moduleMapper.getListQuery(map);
	}

	@Override
	public void update(Module module) {
		moduleMapper.updateByPrimaryKeySelective(module);
	}

	@Override
	public void delId(Integer id) {
		moduleMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void insert(Module module) {
		moduleMapper.insertSelective(module);
		
	}

	@Override
	public Integer count() {
		ModuleExample example=new ModuleExample();
		return moduleMapper.countByExample(example);
	}

	@Override
	public List<Module> getAll(Map map) {
		return moduleMapper.getAll(map);
	}

}
