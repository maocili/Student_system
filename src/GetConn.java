import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GetConn {
	static Connection conn;
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://web.maocil.cn:1433;DatabaseName=student_system","admin","990219Maocil");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
}
