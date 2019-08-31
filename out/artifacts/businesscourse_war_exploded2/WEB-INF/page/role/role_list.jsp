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
    <title>角色查询</title>
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
                    f1.attr("action", "role/loadupdate.do");
                    f1.submit();

                } else {
                    alert("必须选自一个（只能有一个）进行修改");
                }
            });

            //给删除按钮绑定事件
            $("#delete").click(function() {
                if (confirm("您确定要删除角色吗")) {
                    //提交表单
                    var f1 = $("#f1");
                    f1.attr("action", "role/delete.do");
                    f1.submit();
                }

            });

        });

        //checkboxfun 实现全选货全不选
        function checkboxfun(v) {
            //alert(v.checked);
            var roleroleId = $("input[id=ids]");
            //遍历所有的checkbox
            roleroleId.each(function(i) {
                //设置checked的值
                this.checked = v.checked;

                //	$(this).attr("checked",v.checked);
            });
        }
    </script>

</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>系统管理</li>
        <li>角色管理</li>
        <li>查询角色</li>
    </ul>
</div>
<form action="role/list.do" method="post" id="f1" class="form-inline">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>角色名称</label> <input type="text" class="form-control"
                                       name="roleName" placeholder="请输入角色名称" />
        </div>
        <input type="submit" value="查询角色" class="btn btn-success" /> <a
            href="role/loadadd.do" class="btn btn-info">添加角色</a> <input
            type="button" id="update" value="修改角色" class="btn btn-primary" /> <input
            type="button" id="delete" value="删除角色" class="btn btn-danger" />
    </div>
    <div class="alert alert-warning alert-dismissible" style="display: ${errorinfo==null?'none':'block' };" role="alert">
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
                <th>角色编号</th>
                <th>角色名称</th>
                <th>角色描述</th>

            </tr>
            <c:forEach items="${list }" var="role">
                <tr>
                    <td><input type="checkbox" id="ids" name="roleId"
                               value="${role.roleId }" /></td>
                    <td>${role.roleId }</td>
                    <td>${role.roleName }</td>
                    <td>${role.roleDesc }</td>
                </tr>
            </c:forEach>

        </table>

    </div>
    <div align="right" style="padding: 10px;">
        <pg:pager items="${total }" url="role/list.do" maxIndexPages="3"
                  export="currentPageNumber=pageNumber" scope="request">
            <pg:param name="roleName" value="${roleName }" />

            <jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
        </pg:pager>
    </div>
</form>
</body>
</html>