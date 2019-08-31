<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限变更</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>


</head>
<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
			<li>系统管理</li>
			<li>权限管理</li>
			<li>权限变更</li>
		</ul>
	</div>
	<form action="anthority/change.do" method="post" id="f1"
		class="form-inline">
		<input type="hidden" name="roleId" value="${role.roleId }" />

		<div class="row alert alert-info" style="margin: 0px; padding: 10px;">
			<h4 align="center">${role.roleName }</h4>
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table ">
				<tr>

					<th>第一级菜单</th>
					<th>第二级菜单</th>

				</tr>
				<c:forEach items="${list }" var="menu">
					<c:if test="${menu.parentMenuId ==0 }">
						<tr>
							<td><label> <input type="checkbox" name="menuIds"
									value="${menu.menuId }"
								
									
									<c:forEach items="${rmlist }" var="rm" >
										<c:if test="${rm.menuId==menu.menuId }">checked</c:if>
									</c:forEach>
									 
									 />${menu.menuName }
							</label></td>
							<td><c:forEach items="${list }" var="subm">
									<c:if test="${menu.menuId ==subm.parentMenuId }">
										<label><input type="checkbox" name="menuIds"
										<c:forEach items="${rmlist }" var="rm" >
										<c:if test="${rm.menuId==subm.menuId }">checked</c:if>
									</c:forEach>
										
											value="${subm.menuId }" />${subm.menuName }</label>
									</c:if>
								</c:forEach></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>

		</div>
		<div class="row">
			<div class="col-sm-7" align="center">
				<input type="submit" value="权限变更" class="btn btn-success" />

			</div>
		</div>
	</form>
</body>
</html>