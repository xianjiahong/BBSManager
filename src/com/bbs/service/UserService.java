package com.bbs.service;

import java.text.ParseException;
import java.util.List;

import com.bbs.entity.User;

/**
 * �����û���ҵ�񷽷�
 * @author dell
 *
 */
public interface UserService {
	boolean Verification(String userId,String userPsw);
	boolean save(User user);
	List<User> getUserList() throws ParseException;
	User findEdit(String userId);
	boolean delAll(String userIds);
	boolean delById(String userId);
	List<User> findById(String userId);
	boolean update(User user);
}
