<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
        body {margin:0px auto;overflow:hidden;
        	background:url(images/loginbg.jpg) no-repeat;background-size:100%;}
        h2{height: 100px;}
        span{font-size: 30px; color: #2E9AFE; }
        .text{width:200px; height:36px; background-color:#81DAF5;
        	 border:solid 1px #153966; font-size:26px;}
        .but{width:80px; height:36px;
        	background-color:#819FF7;color: #fff}
</style>
</head>
<body>
		<h2 align="center"><font color="#ffffff">欢迎登录...</font></h2>
		<br>
		<form name="ThisForm" method="post" action="LoginServlet">		  
		    <table width="32%" height="240" border="0" align="center">		      
				<tr>
					<td width="88" height="40" valign="bottom">
						<div align="right"><span>账号:</span></div>
					</td>	
					<td>	
						<div align="left">
							<input class="text" type="text" name="username" >
						</div>
					</td>
				</tr>
                <tr>
					<td height="48" valign="bottom">
						<div align="right"><span>密码:</span></div>
					</td>					
					<td height="48" colspan="2" valign="bottom">
						<input class="text" type="password" name="password" >
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;
						<input class="but" type="submit" onclick="return denglu()" value="登录"/>
					</td>
					<td >
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="but" type="button" onclick="zhuce()" value="注册"/>
					</td>
					
				</tr>	
			  				
            </table>                    
                      
        </form>
</body>

<script type="text/javascript">
		 function denglu()
		 {                                                                                         
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }			
			 return true;
		 }
		 
		 function zhuce(){
			 window.location.href="register.jsp";
		 }
		 		
     </script>
</html>