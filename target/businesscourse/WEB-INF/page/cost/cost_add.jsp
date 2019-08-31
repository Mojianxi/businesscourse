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
    <title>费用添加</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>系统管理</li>
        <li>费用管理</li>
        <li>添加费用</li>
    </ul>
</div>
<form action="cost/add.do" method="post" class="form-horizontal">
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">费用基本信息</h5>
    <div class="row">
        <div class="col-sm-7">
            <div class="form-group">
                <label class="col-sm-3 control-label">费用名称</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="costName"
                           placeholder="请输入费用名称" />
                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="form-group">
                <label class="col-sm-3 control-label">费用描述</label>
                <div class="col-sm-9">
						<textarea rows="" cols="" name="costDesc" class="form-control"
                                  placeholder="请输入费用描述信息"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-7" align="center">
            <input type="submit" value="添加费用" class="btn btn-success"/>
            <a href="cost/list.do" class="btn btn-danger">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>