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
<title>Insert title here</title>
</head>
<body>
	<form action="../DeleteServlet" id="form1" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
		   <tr>
		        <td width="25%" style="text-align:center;background-color:#f5f5f5;
		        	vertical-align:middle;">帐号</td>
		        <td><input type="text" name="account" id="account" 
		        	value="<%=request.getParameter("delaccount")%>"/>
		        <span id="accounttip" style="color:red; margin-left: 10px;"></span></td>
		    </tr>
		   
		    <tr>
		        <td style="text-align:center;background-color:#f5f5f5;vertical-align:middle;">删除吗？</td>
		        <td>
		            <button id="submit_btn" class="btn btn-primary" type="submit" >
		            	确定</button> &nbsp;&nbsp;
		            <button type="button" class="btn btn-success" name="backid" id="backid">取消</button>		            
		        </td>
		    </tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	$('#backid').click(function(){
		window.location.href="index.jsp";
	});
</script>
</html>