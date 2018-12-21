package cn.vo.service;

import java.util.List;
import java.util.Map;

import cn.vo.pojo.User;
import io.swagger.models.auth.In;

public interface IUserService {
	
	User getByLoginName(String loginName);
	
	List<User> getListQuery(Map map);
	
	User getById(Integer id);

	void insertUser(User user);
	
	void updateId(User user);
	void delId(Integer id);
	
	Integer getCount();
}
