package zw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  



public class RegServlet extends HttpServlet{
 
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
	        String str = "";
	        String account = request.getParameter("account");
    		String password = request.getParameter("password");
    		
    		
	        try {  
	        	
	    		String sql = "insert into users (Account,Password) " +
	    				"values('"+account+"','"+password+"')";

	      		int k = DBUtil.Update(sql);
	          	                     
	            if(k>0){	        
	            	str="注册成功";
	    		}else{
	    			str="注册失败";
	    		}
	                   
	        }  
	        catch(Exception ex){  
	            ex.printStackTrace();  
	        }finally{  
	        	DBUtil.close();
	        	out.print(str);
	            out.flush();  
	            out.close();  
	        }          
	}

}
