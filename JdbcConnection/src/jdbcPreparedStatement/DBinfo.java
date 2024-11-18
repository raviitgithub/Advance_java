package jdbcPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBinfo {
String driver = "oracle.jdbc.driver.OracleDriver";
String path = "jdbc:oracle:thin:@localhost:1521:orcl";
String user = "system";
String pass = "root";

public static Connection getCon() throws SQLException{
	return DriverManager.getConnection(path, user, pass);
}
}
