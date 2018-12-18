package cn.vo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vo.dao.ModuleMapper;
import cn.vo.pojo.Module;
import cn.vo.service.IModuleService;

@Service
public class ModuleServiceImpl implements IModuleService {
	
	@Autowired
	private ModuleMapper moduleMapper;

	@Override
	public List<Module> getByUserId(Integer userId) {
		return moduleMapper.getByUserId(userId);
	}

}
