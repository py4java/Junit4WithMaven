package com.urbanladder.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionService {

	private Connection connection;

	private String driver;
	private String url;
	private String username;
	private String password;
	Properties props = null;

	public Connection getConnection(String propertiesFile) throws Exception {
		props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream(propertiesFile));
		driver = props.getProperty("db.driver");
		url = props.getProperty("db.url");
		username = props.getProperty("db.username");
		password = props.getProperty("db.password");
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
