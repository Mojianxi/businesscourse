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
    <title></title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>系统管理</li>
        <li>用户管理</li>
        <li>查看用户</li>
    </ul>
</div>
<form action="" method="post" class="form-horizontal">
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">员工基本信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工姓名</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${staffinfo.staffName}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工性别</label>
                <div class="col-sm-5">
                    <p class="form-control-static">${staffinfo.staffSex}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">员工年龄</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${staffinfo.staffAge}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">薪资</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${staffinfo.staffSalary}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">角色</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${staffinfo.roleName}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系电话</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${staffinfo.staffPhone}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户微信</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${staffinfo.staffWechat}</p>
                </div>
            </div>
        </div>
    </div>
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">账号信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户账号</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${staffinfo.staffAccount}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户密码</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${staffinfo.staffPass}</p>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-10" align="center">
            <a href="staff/loadupdate.do?staffId=${staffinfo.staffId}"
               class="btn btn-primary">修改用户信息</a> <a href="staff/list.do"
                                                     class="btn btn-danger">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>