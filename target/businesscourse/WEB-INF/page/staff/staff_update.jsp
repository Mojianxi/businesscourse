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
    <title>用户修改</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>系统管理</li>
        <li>用户管理</li>
        <li>修改用户</li>
    </ul>
</div>
<form action="staff/update.do" method="post" class="form-horizontal">
    <input type="hidden" name="staffId" value="${staffinfo.staffId}" />
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">用户基本信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户姓名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="staffName"
                           placeholder="请输入用户姓名" value="${staffinfo.staffName}" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户性别</label>
                <div class="col-sm-5">
                    <select name="staffSex" class="form-control">
                        <option ${staffinfo.staffSex=='保密'?'selected':'' }>保密</option>
                        <option ${staffinfo.staffSex=='男'?'selected':'' }>男</option>
                        <option ${staffinfo.staffSex=='女'?'selected':'' }>女</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户年龄</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="userAge"
                           placeholder="请输入用户年龄" value="${staffinfo.staffAge}" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">薪资</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="staffSalary"
                           placeholder="请输入薪资" value="${staffinfo.staffSalary}" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">角色</label>
                <div class="col-sm-9">
                    <select name="roleId" class="form-control">
                        <c:forEach items="${list }" var="role">
                            <option value="${role.roleId }" ${role.roleId==staffinfo.roleId?'selected':'' }>${role.roleName }</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系电话</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control"  name="staffPhone" value="${staffinfo.staffPhone}"
                           placeholder="请输入电话" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户微信</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control"  name="staffWechat" value="${staffinfo.staffWechat}"
                           placeholder="请输入微信号" />
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
                    <input type="text" class="form-control" name="staffAccount"
                           placeholder="请输入用户账号" readonly="readonly" value="${staffinfo.staffAccount}" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户密码</label>
                <div class="col-sm-9">
                    <input type="password" class="form-control" name="staffPass"
                           placeholder="请输入用户密码" value="${staffinfo.staffPass}" />
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-10" align="center">
            <input type="submit" value="修改用户" class="btn btn-success" /> <a
                href="staff/list.do" class="btn btn-danger">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>