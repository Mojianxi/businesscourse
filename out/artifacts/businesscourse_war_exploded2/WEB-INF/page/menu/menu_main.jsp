<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(function(){
	var id='${menu.menuId }';
	if(id=='0'){
		$("#update").hide();
		$("#delete").hide();
	}else{
		$("#update").show();
		$("#delete").show();
	}
	
	
	//给'删除'的超链接添加事件
	$("#delete").click(function(){
		
		if(confirm("确定要删除吗")){
			window.location="menu/delete.do?menuId=${menu.menuId }";
		}
		
	});
});


</script>
</head>
<body>

	<a href="menu/loadadd.do?menuId=${menu.menuId }" class="btn btn-info">添加下级菜单</a>
	<a href="menu/loadupdate.do?menuId=${menu.menuId }" class="btn btn-primary"  id="update"  >修改菜单</a>
	<a href="javascript:void(0)" class="btn btn-danger" id="delete">删除菜单</a>
	<h5 class="page-header alert-info"
		style="margin: 0px; padding: 10px; margin-bottom: 10px">菜单详细信息</h5>
	
	<div class="row">
		<form class="form-horizontal">
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单名称</label>
				<div class="col-sm-9">
					<p class="form-control-static">${menu.menuName }</p>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-3 control-label">上级菜单</label>
				<div class="col-sm-5">
					<p class="form-control-static">${menu.parentName }</p>
				</div>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label class="col-sm-3 control-label">菜单地址</label>
				<div class="col-sm-9">
					<p class="form-control-static">${menu.menuUrl }</p>
				</div>
			</div>
		</div>
		</form>
	</div>
</body>
</html>