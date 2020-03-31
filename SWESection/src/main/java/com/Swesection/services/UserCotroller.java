package com.Swesection.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Connection.SqlConnection;
import com.Swesection.models.*;

@RestController
public class UserCotroller {
	@RequestMapping("/hello")
	public String welcome() {
		return "Hello Andrew";
		 
	}
	
	@RequestMapping("/list")
	public List<User> getAllStudents()
	{
		List<User> users = new ArrayList<User>();
		users.add(new User("2014","Ahmed",3.4));
		users.add(new User("2014","Mohamed",3.4));
		users.add(new User("2014","Youssef",3.4));
		return users;
	}
	
	@RequestMapping(value="/hello",method = RequestMethod.POST)
	public String welcome(@RequestBody String name)
	{
		return "Hi "+name;
	}
	

	@RequestMapping("/connect")
	public SqlConnection connection() throws SQLException
	{
		return SqlConnection.getInstance();
	}
 
}
