package helpers;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementUpdateExample {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@10.56.110.151:1521:testdb1";
	private static final String DB_USER = "amcare_sit";
	private static final String DB_PASSWORD = "amcare_sit";


	public static void updateRecordIntoDbUserTable(String updateTableSQL) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			
			String updateTableSQL1 = "UPDATE MERCHANT_TOKEN_DETAILS"
					+ " SET TRANSACTIONALLOWED = 'SBA' "
					+ " WHERE MERCHANTID = 1000045801";

			System.out.println(updateTableSQL1);

			// execute update SQL stetement
			statement.execute(updateTableSQL1);

			System.out.println("Record is updated to DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                              DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}

