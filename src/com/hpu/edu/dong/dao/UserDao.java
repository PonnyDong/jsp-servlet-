package com.hpu.edu.dong.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.hpu.edu.dong.domain.User;
import com.hpu.edu.dong.utils.DataSourceUtils;

public class UserDao {

	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from [user] where username=? and password=?";
		return  runner.query(sql, new BeanHandler<User>(User.class), username,password);
	}

	public int regist(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into [user] (username,password,email,sex) values (?,?,?,?)";
		int update = runner.update (sql, user.getUsername(),user.getPassword(),
				user.getEmail(),user.getSex());
		return update;
	}
	//校验用户名是否存在
	public Long checkUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from [user] where username=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(), username);
		return query;
	}

	

}
