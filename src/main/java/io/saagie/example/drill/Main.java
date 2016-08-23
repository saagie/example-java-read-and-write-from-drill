package io.saagie.example.drill;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;

public class Main {


	private static final Logger logger = Logger.getLogger("io.saagie.example.drill.Main");
	private static final String JDBC_DRIVER_NAME = "org.apache.drill.jdbc.Driver";
	private static String connectionUrl;

	public static void main(String[] args) throws IOException {

		if (args.length < 1) {
			logger.severe("1 arg is required :\n\t- connectionurl ex: jdbc:drill:drillbit=namenode:31010,datanode1:31010,datanode2:31010,datanode3:31010");
			System.err.println("1 arg is required :\n\t-connectionurl  ex: jdbc:drill:drillbit=namenode:31010,datanode1:31010,datanode2:31010,datanode3:31010");
			System.exit(128);
		}
		// Get url Connection
		connectionUrl = args[0];
		logger.info("connectionUrl : " + connectionUrl);
		// Init Connection
		Connection connection = null;

		//==== Select data from Drill Table
		String sqlStatement = "SELECT * FROM cp.`employee.json`";
		try {
			Class.forName(JDBC_DRIVER_NAME);
			connection = DriverManager.getConnection(connectionUrl);
			Statement st = connection.createStatement();
			st.executeQuery(sqlStatement);

		} catch (Exception e) {
			logger.severe(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				// swallow
			}
		}
	}
}
