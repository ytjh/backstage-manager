package cn.vo.service;

import java.util.List;

import cn.vo.pojo.Module;

public interface IModuleService {
	
	List<Module> getByUserId(Integer userId);

}
