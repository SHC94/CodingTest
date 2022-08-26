package codingtest.self.lotteecommece;

import java.sql.*;

public class Task09 {
	
	public static void main(String[] args) {

		solution();
		
	}//end main()
	
	public static void solution() {
        
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from emp where empno = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			con = DriverManager.getConnection(url, "gudcjf4757", "tiger");
			
			//stmt = con.prepareStatement(sql);
			
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end solution()

}//end class()
