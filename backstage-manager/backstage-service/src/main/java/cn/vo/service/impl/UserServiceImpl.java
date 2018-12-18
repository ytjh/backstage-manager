package cn.vo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.vo.dao.UserMapper;
import cn.vo.pojo.User;
import cn.vo.pojo.UserExample;
import cn.vo.pojo.UserExample.Criteria;
import cn.vo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getByLoginName(String loginName) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andLoginNameEqualTo(loginName);
		List<User> list=userMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
