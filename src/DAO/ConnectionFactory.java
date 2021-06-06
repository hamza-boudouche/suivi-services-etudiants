package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://localhost:3306/suiviserviceetudiants?allowLoadLocalInfile=true";
	public static final String USER = "root";
	public static final String PASSWORD = System.getenv("PASSWORD");
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

	private ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}

	public static int importData(String path, String table) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement statement = connection.createStatement();
			String command = " LOAD DATA LOCAL INFILE '" + path + "' INTO TABLE " + table + " FIELDS TERMINATED BY \',\' " + " LINES TERMINATED BY \'\\n\'";
			return statement.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
