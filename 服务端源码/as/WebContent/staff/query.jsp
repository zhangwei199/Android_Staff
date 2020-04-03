<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
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
		<form class="form-inline definewidth m20" action="../QueryServlet" method="post">
			员工帐号：
			<input type="text" name="account" id="account">
			<input type="hidden" name="account2" id="account2">
			&nbsp;&nbsp;			
			<input type="submit" value="查询" class="btn btn-primary">
			&nbsp;&nbsp;
			<button class="btn btn-info" id="refresh">
				刷新
			</button>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-success" id="addnew">
				新增员工
			</button>
		</form>
		<table class="table table-bordered table-hover definewidth m10"
			id="table1">
			<thead>
				<tr>
					<th>
						账号
					</th>
					<th>
						姓名
					</th>
					<th>
						邮箱
					</th>
					<th>
						移动电话
					</th>
					<th>
						年龄
					</th>
					<th>
						籍贯
					</th>					
					<th>
						月薪
					</th>
					<th>
						编辑
					</th>
					<th>
						删除
					</th>
				</tr>
			</thead>
			<tbody>
				
			
			<%
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				list = (List<Map<String, Object>>)session.getAttribute("staffquery");				
				//if(list.size() != 0){
					for(int i=0;i<list.size();i++){	
			%>
			
			
				<tr>
					<td>
						<%=list.get(i).get("account") %>
					</td>
					<td>
						<%=list.get(i).get("nickname") %>
					</td>
					<td>
						<%=list.get(i).get("email") %>
					</td>
					<td>
						<%=list.get(i).get("phone") %>
					</td>
					<td>
						<%=list.get(i).get("age") %>
					</td>
					<td>
						<%=list.get(i).get("addr") %>
					</td>								
					<td>
						<%=list.get(i).get("pay") %>
					</td>
					<td>
						<form action="edit.jsp" name="editform">						
							<button style="margin-left: 10px;background-color: #FFF;" class="" type="submit" >
							<img src="../images/edit-icon.png" class="icons" style="vertical-align: middle;"></button>
							<input type="hidden" id="editaccount" name="editaccount" 
									value="<%=list.get(i).get("account")%>"/>
						</form>
					</td>
					<td>
						<form action="delete.jsp" name="delform">						
							<button style="margin-left: 10px;background-color: #FFF;" type="submit" >
							<img src="../images/trash-icon.png" class="icons" style="vertical-align: middle;"></button>
							<input type="hidden" id="delaccount" name="delaccount" 
									value="<%=list.get(i).get("account")%>"/>
						</form>						
					</td>
				</tr>
			<%} %>
			</tbody>
		</table>
		<div class="inline pull-right page">
			<span id="totalCount">1</span> 条记录
			<span id="pageIndex"></span>/
			<span id="totalPage"></span> 1页
			<span id="firstpage" style="cursor: pointer; color: blue;">首页</span>
			<span id="prepage" style="cursor: pointer; color: blue;">上一页</span>
			<span class='current'><span id="pageIndex2"></span>
			</span>
			<span id="nextpage" style="cursor: pointer; color: blue;">下一页</span>
			<span id="lastpage" style="cursor: pointer; color: blue;">最后一页</span>
		</div>
</body>

<script>
		$('#firstpage').click(function(){
		 	alert("温馨提示：当前已在首页。");
		 });
		 
		 $('#lastpage').click(function(){
			 alert("温馨提示：当前已在尾页。");
		 });
		 
		 $('#prepage').click(function(){
			 alert("温馨提示：暂无数据。");
		 });
		 
		 $('#nextpage').click(function(){
			 alert("温馨提示：暂无数据。");
		 });	 
		 $('#addnew').click(function(){
				window.location.href="add.jsp";
		 });		 	 
		 $('#refresh').click(function(){
			 window.location.reload();				
		 });
		 $('.delete').click(function(){
			 if(confirm("确定要删除吗？")){
					alert("确定");					
					window.location.href="delete.jsp";
				}else{
					alert("取消");
				}					
		 });
			
	</script>
</html>