<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background: url(../images/liuyan.jpg) no-repeat;background-size:100%;">
	<h2> &nbsp;&nbsp;&nbsp;&nbsp;写下你的意见或者建议，我会做得更好！</h2>
	<br>
	<form action="../staff/success.html" method="post">
		<table border="0">
		     <tr>
		         <td style="font-size: 21px;">主题:&nbsp;&nbsp;</td>
		         <td><input type="text" name="liuyanTitle" size="85" height="50"/></td>
		     </tr>
		     <tr>
		         <td style="font-size: 21px;">内容:&nbsp;&nbsp;</td>
		         <td>
		              <textarea name="liuyanContent" style="width:800px;height:300px;"></textarea>
                 </td>
		     </tr>
		     <tr>
		         <td style="font-size: 11px;">&nbsp;</td>
		         <td>
		             <input type="submit" name="" value="提交">
                 </td>
		     </tr>
		</table>
	</form>
</body>
</html>