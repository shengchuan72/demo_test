package cn.itcast.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.mapper.UserMapper;
import cn.itcast.ssm.po.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User findUserById(int id) throws Exception {
		User user = userMapper.selectByPrimaryKey(id);
		System.out.println(user);
		//调用usermapper查询用户信息
		return userMapper.selectByPrimaryKey(id);
	}
	
	//事务测试
	public void saveUser()throws Exception {
		
		//先删除一个用户
		userMapper.deleteByPrimaryKey(67);
		//再插入一个用户(插入同名用户，数据抛出异常),预期结果事务回滚，删除的用户无效
		
		User user = new User();
		user.setUsername("张三");
		userMapper.insertSelective(user);
		
		
	}

}
