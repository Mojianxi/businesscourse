<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>班级查询</title>
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
                    f1.attr("action", "staff/loadupdate.do");
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
                    f1.attr("action", "staff/delete.do");
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
        <li>营销管理</li>
        <li>班级管理</li>
        <li>班级查询</li>
    </ul>
</div>
<form action="class/list.do" method="post" id="f1" class="form-inline">


    <div class="row" style="padding: 15px;">
        <table class="table ">
            <tr>
                <th><input type="checkbox" onclick="checkboxfun(this)" /></th>
                <th>班级编号</th>
                <th>开讲内容</th>
                <th>开讲时间</th>
                <th>班级人数</th>
                <th>开班地址</th>
                <th>班级收款</th>
            </tr>
            <c:forEach items="${list }" var="classInfo">
                <tr>
                    <td><input type="checkbox" id="ids" name="classId" value="${classInfo.classId}"  /></td>
                    <td>${classInfo.classId}</td>
                    <td>${classInfo.trainContent }</td>
                    <td><fmt:formatDate value="${classInfo.trainDate }" type="date" /></td>
                    <td>${classInfo.trainNumber}</td>
                    <td>${classInfo.trainAddress}</td>
                    <td>${classInfo.trainMakeCash}</td>
                    <td><a href="class/showclass_list.do?classId=${classInfo.classId}">查看</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div align="right" style="padding: 10px;">
        <pg:pager items="${total }" url="class/list.do" maxIndexPages="3"
                  export="currentPageNumber=pageNumber" scope="request">
            <pg:param name="customerName" value="${customerName }" />
            <jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
        </pg:pager>
    </div>
</form>
</body>
</html>