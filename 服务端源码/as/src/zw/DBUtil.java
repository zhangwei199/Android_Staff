package zw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	    public static final  String URL="jdbc:mysql://localhost:3306/zw";	 
	    public static final String NAME = "root";
		public static final String PASSWORD = "123456";
	 	public static final String DREIVER = "com.mysql.jdbc.Driver"; 
	 	private static Connection conn=null;
		private static PreparedStatement ps=null;
		private static ResultSet res=null;
	     
	 	
		//加载驱动连数据库
		public static Connection getconn(){
				try {
						Class.forName(DREIVER);
						conn=DriverManager.getConnection(URL,NAME,PASSWORD);
				} catch (ClassNotFoundException e) {
						e.printStackTrace();
				} catch (SQLException e) {
						e.printStackTrace();
				}
				return conn;
		}
		
		//更新方法
			public static int Update(String sql){
					int k=0;
					getconn();
					try {
						ps=conn.prepareStatement(sql);
						k=ps.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						close();
					}
					return k;
			}

			//关闭链接、释放资源 .
			public static void close(){
				try {
					if(res!=null){
						res.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
}
