package com.Swesection;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Connection.SqlConnection;

@SpringBootApplication
public class MainController {
	public static void main(String []args ) throws Exception {
		//SpringApplication.run(MainController.class, args);
		SqlConnection con =SqlConnection.getInstance();
		System.out.print(con.selectData("select * from users"));
		//System.out.println(con.selectData("select * from Users"));
	}
}
