package com.hpu.edu.dong.service;

import java.sql.SQLException;

import com.hpu.edu.dong.domain.User;
import com.hpu.edu.dong.dao.UserDao;

public class UserService {

	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		return dao.login(username,password);
		
	}

	public boolean register(User user) {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		int row=0;
		try {
			row = dao.regist(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row>0?true:false;
	}
	//检测用户名是否存在
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		Long isExist=0L;
		try {
			isExist=dao.checkUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isExist>0?true:false; 
	}

}
