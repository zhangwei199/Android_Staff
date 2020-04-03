<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
<title>员工添加</title>
</head>
<body>
    <form action="../AddServlet" id="form1" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
		    <tr>
		        <td width="15%" style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">工号</td>
		        <td><input type="text" name="account" id="account" value=""/>
		        <span id="accounttip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>
		    <tr>
		        <td style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">姓名</td>
		        <td><input type="text" name="name" id="name" value=""/>
		        <span id="nametip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>		  
		    <tr>
		        <td style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">性别</td>
		        <td><input type="text" name="sex" id="sex" value=""/>
		        <span id="sextip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>
		    <tr>
		        <td style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">手机</td>
		        <td><input type="text" name="phone" id="phone" value=""/>
		        <span id="phonetip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>
		    <tr>
		        <td style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">年龄</td>
		        <td><input type="text" name="age" id="age" value=""/>
		        <span id="birthdaytip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>
		    
		    <tr>
		        <td style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">月薪</td>
		        <td><input type="text" name="pay" id="pay" value=""/>
		        <span id="paytip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>
		    <tr>
		        <td class="tableleft"></td>
		        <td>
		            <button id="submit_btn" class="btn btn-primary" type="submit" onclick="return add()">保存</button> &nbsp;&nbsp;
		            <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
		            &nbsp;&nbsp; <span id="msg" style="color:red; margin-left: 10px;"></span>
		        </td>
		    </tr>
		</table>
	</form>
</body>
<script>
	function add(){                                                                                         		
			if($('#account').val() == ''){
				$('#accounttip').text("账号不能为空！");
				$('#account').focus();
				return false;
			}else if($('#nickname').val() == ''){
				$('#accounttip').text("");
				$('#nicknametip').text('姓名不能为空！');
				$('#g_name').focus();
				return false;
			}else{
				$('#accounttip').text('');
				$('#nicknametip').text('');					
				return true;
			}
	}
	
	$(function () {       
		$('#backid').click(function(){
				window.location.href="index.jsp";
		 });
    });
</script>
</html>