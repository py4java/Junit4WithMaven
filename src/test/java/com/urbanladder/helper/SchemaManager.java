package com.urbanladder.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

import org.apache.ibatis.jdbc.ScriptRunner;

public class SchemaManager {

	private ConnectionService connectionService;

	public SchemaManager(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	/* ScriptRunner runner = null; */

	public void executeSQLScript(String sqlFileLocation, String propertiesFile) {
		/*
		 * try {
		 * 
		 * runner = new ScriptRunner(connectionService.getConnection(propertiesFile));
		 * inputStream =
		 * this.getClass().getClassLoader().getResourceAsStream(sqlFileLocation);
		 * runner.runScript(new InputStreamReader(inputStream));
		 * runner.setAutoCommit(true);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

		try (Connection conn = connectionService.getConnection(propertiesFile);
				Statement stmt = conn.createStatement();
				InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(sqlFileLocation);) {
			String line = null;
			StringBuilder builder = new StringBuilder();
			int c = 0;
			while ((c = inputStream.read()) != -1) {
				builder.append((char) c);

			}
			line = builder.toString();
			stmt.execute(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
