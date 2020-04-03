package zw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  



public class EditServlet extends HttpServlet{
 
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
    		String name = request.getParameter("name");
    		String sex = request.getParameter("sex");
    		String phone = request.getParameter("phone");
    		String age = request.getParameter("age");    		
    		String pay = request.getParameter("pay");
    		
    		
	        try {  
	        	
	        	String sql = "update staffs set name= '"+name+"',sex= '"+sex+"',phone= '"+phone+"',"+
	        			"age= '"+age+"',pay= '"+pay+"' where account='"+account+"'";

	      		int k = DBUtil.Update(sql);
	          	                     
	            if(k>0){	        
	            	str="修改成功";
	    		}else{
	    			str="修改失败";
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
