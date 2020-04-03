<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="RegServlet" method="post" id="form1" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
		    <tr>
		        <td width="30%" style="text-align:center;
		        background-color:#f5f5f5;vertical-align:middle;">帐号</td>
		        <td><input type="text" name="account" id="account" value=""/>
		        <span id="accounttip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>		  
		    <tr>
		        <td style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">密码</td>
		        <td><input type="password" name="password" id="password" value=""/>
		        <span id="passwordtip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>
		    <tr>
		        <td style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">确认密码</td>
		        <td><input type="password" name="password2" id="password2" value=""/>
		        <span id="password2tip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>
		    		    
		    <tr>
		        <td class="tableleft"></td>
		        <td>
		            <button id="submit_btn" class="btn btn-primary" type="submit" onclick="return rigister()">
		            	注册</button> &nbsp;&nbsp;
		            <button type="button" class="btn btn-success" name="backid" id="backid">返回</button>
		            &nbsp;&nbsp; <span id="msg" style="color:red; margin-left: 10px;"></span>
		        </td>
		    </tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function rigister(){
		
			if($('#account').val() == ''){
				$('#accounttip').text('账户不能为空！');	
				$('#account').focus();
				return false;
			}else if($('#password').val() == ''){
				$('#accounttip').text('');
				$('#passwordtip').text('密码不能为空！');
				$('#password').focus();
				return false;
			}else if($('#password').val() != $('#password2').val()){
				$('#accounttip').text('');
				$('#passwordtip').text('');
				$('#password2tip').text('两次密码不一致');
				$('#password2').focus();
				return false;
			}else{
				$('#accounttip').text('');
				$('#passwordtip').text('');
				$('#password2tip').text('');
				return true;		
			}
	};
	$(function () {       
		$('#backid').click(function(){
				window.location.href="login.jsp";
		 });
	
	});
</script>
</html>