<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户查看</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>

</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>欢迎您登录，${staff.staffName}</li>
    </ul>
</div>
<div>
    <h2>
        &nbsp;&nbsp;&nbsp;<small>当前登录时间：<fmt:formatDate
            value="<%=new Date()%>" type="both" />
    </small>
    </h2>

    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">用户基本信息</h5>
    <form action="" class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">用户姓名:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${staff.staffName}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">用户性别:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${staff.staffSex}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">用户年龄:</label>
            <div class="col-sm-10">
                <p class="form-control-static">${staff.staffAge}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">用户薪资:</label>
            <div class="col-sm-10">
                <p class="form-control-static">￥：${staff.staffSalary}</p>
            </div>
        </div>

    </form>
</div>
</body>
</html>