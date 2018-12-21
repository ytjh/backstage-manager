package cn.vo.service.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<User> getListQuery(Map map) {
		return userMapper.getListQuery(map);
	}
	// 根据id查询信息
	@Override
	public User getById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	//添加用户
	@Override
	public void insertUser(User user) {
		userMapper.insert(user);
		
	}
	//编辑信息
	@Override
	public void updateId(User user) {
		userMapper.updateByPrimaryKeySelective(user);
		
	}
	//根据id删除
	@Override
	public void delId(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	//查询总数
	@Override
	public Integer getCount() {
		UserExample example=new UserExample();
		return userMapper.countByExample(example);
	}

}
