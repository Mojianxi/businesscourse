<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>课程查询</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function() {

            //给修改按钮绑定事件
            $("#update").click(function() {
                var ids = $("input[id=ids]:checked");
                if (ids.length == 1) {
                    //提交表单
                    var f1 = $("#f1");
                    f1.attr("action", "course/loadupdate.do");
                    f1.submit();

                } else {
                    alert("必须选自一个（只能有一个）进行修改");
                }
            });

            //给删除按钮绑定事件
            $("#delete").click(function() {
                if (confirm("您确定要删除用户吗")) {
                    //提交表单
                    var f1 = $("#f1");
                    f1.attr("action", "user/delete.do");
                    f1.submit();
                }
            });
        });
        //checkboxfun 实现全选货全不选
        function checkboxfun(v) {
            //alert(v.checked);
            var ids = $("input[id=ids]");
            //遍历所有的checkbox
            ids.each(function(i) {
                //设置checked的值
                this.checked = v.checked;
            });
        }
    </script>

</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>系统管理</li>
        <li>课程管理</li>
        <li>课程查询</li>
    </ul>
</div>
<form action="staff/list.do" method="post" id="f1" class="form-inline">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
            <a href="course/loadadd.do" class="btn btn-info">添加课程</a> <input
            type="button" id="update" value="修改课程" class="btn btn-primary" /> <input
            type="button" id="delete" value="删除课程" class="btn btn-danger" />
    </div>
    <div class="alert alert-warning alert-dismissible"
         style="display: ${errorinfo==null?'none':'block' };" role="alert">
        <button type="button" class="close" data-dismiss="alert"
                aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <div align="center" style="color: red;">${errorinfo }</div>
    </div>
    <div class="row" style="padding: 15px;">
        <table class="table ">
            <tr>
                <th><input type="checkbox" onclick="checkboxfun(this)" /></th>
                <th>课程编号</th>
                <th>课程名称</th>
                <th>课程价格</th>
                <th>课程描述</th>
            </tr>
            <c:forEach items="${list}" var="course">
                <tr>
                    <td><input type="checkbox" id="ids" name="courseId" value="${course.courseId}"  /></td>
                    <td>${course.courseId}</td>
                    <td>${course.courseName }</td>
                    <td>${course.coursePrice }</td>
                    <td>${course.courseDesc }</td>
                    <td><a href="user/showuser.do?courseId=${staff.staffId }">查看</a></td>
                </tr>
            </c:forEach>

        </table>

    </div>
    <div align="right" style="padding: 10px;">
        <pg:pager items="${total }" url="user/list.do" maxIndexPages="3"
                  export="currentPageNumber=pageNumber" scope="request">
            <pg:param name="userName" value="${userName }" />

            <jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
        </pg:pager>
    </div>
</form>
</body>
</html>