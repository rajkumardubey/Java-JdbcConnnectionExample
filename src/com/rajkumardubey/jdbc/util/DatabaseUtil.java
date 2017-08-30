package com.rajkumardubey.jdbc.util;

/*
 * <h1>DatabaseUtil</h1>
 * 
 * This utility class wll help us to create database connection.
 * 
 * @author  Raj Kumar Dubey
 * @version 1.0
 * @since   2012-06-25 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	// TODO Please update these variable as per your requirement

	/* Driver name of the Database */
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	/* Database related configurations */
	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jee";
	public static final String USER_ID = "root";
	public static final String PASSWORD = "java";

	/**
	 * <h1>getDatabaseConnection</h1>
	 * 
	 * This static function is used to load the driver of the database &
	 * establish the connection between java & database.
	 */
	public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		/* to load the Driver */
		Class.forName(DRIVER_NAME);

		/* to establish the connection */
		final Connection dbConnection = DriverManager.getConnection(DATABASE_URL, USER_ID, PASSWORD);
		return dbConnection;
	}

}
