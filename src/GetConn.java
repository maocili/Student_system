import java.sql.Connection;
import java.sql.DriverManager;

public class GetConn {
	Connection conn;
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://web.maocil.cn:1433;DatabaseName=student_system","admin","990219Maocil");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
}
