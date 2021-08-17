package com.nicolis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCCon {

	private static Connection conn = null;

	public static Connection getConnection() {

		// url , username, password

		if (conn == null) {
			// establish connection
			String endpoint = "nicolisproj0.cwll09ag1opl.us-east-1.rds.amazonaws.com";

			// url format for postgres jdbc :
			// jdbc:postgresql://[endpoint]/[database]
			// bad but simple
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			String user = "nicxm33";
			String password = "337SqAjnhkBgbvb";

			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return conn;
	}

}
