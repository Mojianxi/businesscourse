<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改客户订单</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>营销管理</li>
        <li>客户管理</li>
        <li>修改订单</li>
    </ul>
</div>
<form action="customer/editrelev.do" method="post" class="form-horizontal">
    <input type="hidden" name="customerId" value="${customer.customerId}" />
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">订单信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户姓名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="userName"
                           placeholder="请输入用户姓名" value="${userinfo.userName }" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户性别</label>
                <div class="col-sm-5">
                    <select name="userSex" class="form-control">
                        <option ${userinfo.userSex=='保密'?'selected':'' }>保密</option>
                        <option ${userinfo.userSex=='男'?'selected':'' }>男</option>
                        <option ${userinfo.userSex=='女'?'selected':'' }>女</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户年龄</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="userAge"
                           placeholder="请输入用户年龄" value="${userinfo.userAge }" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">薪资</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="userSalary"
                           placeholder="请输入薪资" value="${userinfo.userSalary }" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">角色</label>
                <div class="col-sm-9">
                    <select name="roleId" class="form-control">
                        <c:forEach items="${list }" var="role">
                            <option value="${role.roleId }" ${role.roleId==userinfo.roleId?'selected':'' }>${role.roleName }</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>


    </div>
    <div class="row">
        <div class="col-sm-10" align="center">
           <%-- <input type="submit" value="修改用户" class="btn btn-success" />--%>
            <a href="customer/showcustomer.do" class="btn btn-danger">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>