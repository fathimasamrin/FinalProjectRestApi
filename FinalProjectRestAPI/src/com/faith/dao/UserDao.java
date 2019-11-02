package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.User;

public class UserDao implements IUserDao {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
	}

	@Override
	public List<User> getAllDetails()
		{
		// TODO Auto-generated method stub
		return template
				.query("select id,username,password,roleId from LoginUser order by id desc",
				 new RowMapper<User>()
				 {
					 public User mapRow(ResultSet rs,int row) throws SQLException
					 {
						 User user=new User();
						 user.setId(rs.getLong(1));
						 
						 user.setUsername(rs.getString(2));
						 user.setPassword(rs.getString(3));
						 user.setRoleId(rs.getString(4));
						 
						 return user;
					 }
				 
				 });
		
		}

	@Override
	public User searchUserDetails(String searchString)
	{
		// TODO Auto-generated method stub
		String sql="select id,username,password,roleId from loginuser where username=?";
		return template.queryForObject(sql, new Object[] {searchString},
				new BeanPropertyRowMapper<User>(User.class));
		
	
	}

	@Override
	public User getUserById(int uId) {
		// TODO Auto-generated method stub
		String sql="select id,username,password,roleId from LoginUser where id=?";
		return template.queryForObject(sql, new Object[] {uId},
				new BeanPropertyRowMapper<User>(User.class));
	}

	
	

	/*--------------------------INSERT---------------------------------*/

	@Override
	public int insertUserDetails(User user) {

		String sqlOne = "insert into LoginUser(username,password,roleId) values('" + user.getUsername() + "','"
				+ user.getPassword() + "','" + user.getRoleId() + "')";

		return template.update(sqlOne);

	}
	
	/*--------------------------UPDATE---------------------------------*/

	@Override
	public int updateUserDetails(User user) {
		// to update user table
		String sqlOne = "update LoginUser set username='" + user.getUsername() + "',password='" + user.getPassword() + "',roleId='"
				+ user.getRoleId() +  "' where id=?";
		return template.update(sqlOne, new Object[] { user.getId() });

	}


@Override
	public User searchUserDetails(String username,String password) {
	
	String sql = "select id, username,password,roleId from user where username=? and password =?";
	return template.queryForObject(sql, new Object[] { username,password }, new BeanPropertyRowMapper<User>(User.class));
	}
			 
				
}


