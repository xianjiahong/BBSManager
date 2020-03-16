package com.bbs.dao.user;

import java.text.ParseException;
import java.util.List;

import com.bbs.entity.User;

public interface Userdao {
	/**
	 * 验证登录的方法
	 * @param userId 登录的用户名
	 * @param userPsw 登录的密码
	 * @return 用户名和密码相同的个数
	 */
	int Verification(String userId,String userPsw);
	// 用户注册
	int save(User user);
	
	List<User> getUserList() throws ParseException;
	//查询用户信息
	User findEdit(String userId);
	//批量删除
	int delAll(String[] uids);
	//根据id删除用户信息
	int delById(String userId);
	//根据id查找用户信息
	List<User> findById(String userId);
	//更改数据
	int update(User user);
	
	
}
