package zw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
import net.sf.json.JSONObject; 
import zw.DBUtil;

public class LoginServlet extends HttpServlet{
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String ID = request.getParameter("username"); //用于接收android前台的输入的值，此处参数必须要与你前台的值相对应
	        String PW= request.getParameter("password");  
	        boolean type=false;//用于判断账号和密码是否与数据库中查询结果一致
	        response.setContentType("text/html; charset=UTF-8");  
	        PrintWriter out = response.getWriter();  
	        Connection con=null;
	        JSONObject json = new JSONObject();
	        
	       //   JsonConfig jsonConfig = new JsonConfig();
	       // jsonConfig.registerJsonValueProcessor(java.sql.Date.class,new JsonDateValueProcessor());
	        try  
	        {  
	            con=DBUtil.getconn();  
	            Statement stmt=con.createStatement();  
	            String sql="select * from zw.users where Account="+ID+" and Password="+PW;  
	            ResultSet rs=stmt.executeQuery(sql);  
	            while(rs.next())  
	            {  
	                type=true; 
	                
	            }  
	        }  
	        catch(Exception ex)  
	        {  
	            ex.printStackTrace();  
	        }  
	        finally  
	        {  
	        	DBUtil.close();
	        	json.put("msg",  type ); 
	        	out.print(type);
	            //json.put("msg", JSONArray.fromObject(type,jsonConfig)); 
	            //response.getWriter().write(json.toString());
	            //response.getWriter().write("\n"+ID);
	            out.flush();  
	            out.close();  
	        }  
	}

}
