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
    <title>用户添加</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/validator/jquery.validator.css">
    <script type="text/javascript" src="res/validator/jquery.validator.js"></script>
    <script type="text/javascript" src="res/validator/local/zh-CN.js"></script>
    <script type="text/javascript"
            src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        $(function(){

            //绑定事件
            $("#userAccount").blur(function(){
                $.post("user/check.do",{userAccount:$(this).val()},function(data){
                    $("#error").html(data);
                });
            });

        });

    </script>
</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>系统管理</li>
        <li>用户管理</li>
        <li>添加用户</li>
    </ul>
</div>
<form action="staff/add.do" method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true}" class="form-horizontal">
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">用户基本信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户姓名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="staffName"
                           placeholder="请输入用户姓名" data-rule="用户姓名:required;" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户性别</label>
                <div class="col-sm-5">
                    <select name="staffSex" class="form-control">
                        <option>保密</option>
                        <option>男</option>
                        <option>女</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户年龄</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" data-rule="用户年龄:required;"  name="staffAge"
                           placeholder="请输入用户年龄" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">薪资</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" data-rule="用户薪资:required;" name="staffSalary"
                           placeholder="请输入薪资" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">角色</label>
                <div class="col-sm-9">
                    <select name="roleId" class="form-control">
                        <c:forEach items="${list }" var="role">
                            <option value="${role.roleId }">${role.roleName }</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系电话</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" data-rule="联系电话:required;" name="staffPhone"
                           placeholder="请输入电话" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户微信</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" data-rule="微信号:required;" name="staffWechat"
                           placeholder="请输入微信号" />
                </div>
            </div>
        </div>
       <%-- <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户生日</label>
                <div class="col-sm-9">
                    <input  class="form-control" value='<fmt:formatDate value="${staff.staffBirthday}" type="date"/>'
                          type="date"  name="staffBirthday" onclick="WdatePicker()" placeholder="请输入生日" />
                </div>
            </div>
        </div>--%>
    </div>
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">账号信息
        <span id="error" style="color: red;"></span>
    </h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户账号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="staffAccount"  name="staffAccount"
                           placeholder="请输入用户账号" data-rule="用户账号:required;" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户密码</label>
                <div class="col-sm-9">
                    <input type="password" class="form-control" data-rule="用户密码:required;" name="staffPass"
                           placeholder="请输入用户密码" />
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-10" align="center">
            <input type="submit" value="添加用户" class="btn btn-success" /> <a
                href="staff/list.do" class="btn btn-danger">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>