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
    <title>课程添加</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/validator/jquery.validator.css">
    <script type="text/javascript" src="res/validator/jquery.validator.js"></script>
    <script type="text/javascript" src="res/validator/local/zh-CN.js"></script>
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="application/javascript">
        function showPreview(obj) {
            var str=obj.value;
            document.getElementById("previewImg").innerHTML="<img src='"+str+"'/>";
        }
    </script>

</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>系统管理</li>
        <li>课程管理</li>
        <li>添加课程</li>
    </ul>
</div>
<form action="role/add.do" method="post" class="form-horizontal" data-validator-option="{theme:'yellow_right_effect',stopOnError:true}">
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">课程基本信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">课程名称</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="courseName"
                           placeholder="请输入课程名称" data-rule="课程名称:required;" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">课程价格</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" name="coursePrice"
                           placeholder="请输入课程价格" data-rule="课程价格:required;" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">课程描述</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" data-rule="课程描述:required;"  name="courseDesc"
                           placeholder="请输入课程描述" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">课程详情图</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" data-rule="课程详情图:required;" name="coursePic"
                           placeholder="添加课程详情图" />
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-7" align="center">
            <input type="submit" value="添加课程" class="btn btn-success"/>
            <a href="course/list.do" class="btn btn-danger">返回上一级</a>
        </div>
    </div>


</form>
    <form action="">
        请选择图片:<input id="myfile" name="myfile" type="file" onchange="showPreview(this)"/>
        <div id="previewImg"></div>
    </form>
</body>
</html>