package cn.itcast.ssm.service;

import cn.itcast.ssm.po.User;

public interface UserService {
	//根据用户账号查询用户信息
	public User findUserById(int id) throws Exception;
	//事务测试
	public void saveUser()throws Exception;
}
