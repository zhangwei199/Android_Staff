package zw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

public class StaffServlet extends HttpServlet{
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
			doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		 	 	      
	        response.setContentType("text/html; charset=UTF-8");  
	        PrintWriter out = response.getWriter();  
	        Connection con=null;
	        JSONObject json = new JSONObject();
	        String jsons = "";
	        try {  
	            con=DBUtil.getconn();  
	            Statement stmt=con.createStatement();  
	            String sql="select * from staffs";  
	            ResultSet rs=stmt.executeQuery(sql);  
	            
	            ResultSetMetaData md = rs.getMetaData();
	            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	            int columnCount = md.getColumnCount();
	            while(rs.next()){  
	            	Map<String, Object> rowData = new HashMap<String, Object>();

	                for (int i = 1; i <= columnCount; i++) {

	                    rowData.put(md.getColumnName(i), rs.getObject(i));

	                }
	                
	                list.add(rowData);
	                
	            }
	            HttpSession session =request.getSession();
	            session.setAttribute("stafflist", list);
	            	         
	            Gson gson=new Gson();//利用google提供的gson将一个list集合写成json形式的字符串  
	            jsons=gson.toJson(list);  
            
	            
	        }  
	        catch(Exception ex){  
	            ex.printStackTrace();  
	        }  finally  
	        {  
	        	DBUtil.close();	        
	        	json.put("staff", jsons ); 	       
	        	out.print(json);
	            //json.put("msg", JSONArray.fromObject(type,jsonConfig)); 
	            //response.getWriter().write(json.toString());
	            //response.getWriter().write("\n"+ID);	      
	            out.flush();  
	            out.close();  
	        }          
	}

}
