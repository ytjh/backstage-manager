package cn.vo.service;

import cn.vo.pojo.User;

public interface IUserService {
	
	User getByLoginName(String loginName);

}
