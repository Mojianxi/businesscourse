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
    <title>班级详情</title>
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
        <li>查询学员</li>
    </ul>
</div>
<div class="form-horizontal">
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">班级基本信息</h5>
    <div class="row">
        <div class="col-sm-4">
            <div class="form-group">
                <label class="col-sm-3 control-label">班级编号</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${classidInfo.classId}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="form-group">
                <label class="col-sm-3 control-label">开班时间</label>
                <div class="col-sm-5">
                    <p class="form-control-static"><fmt:formatDate value="${classidInfo.trainDate}" type="date" /></p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="form-group">
                <label class="col-sm-3 control-label">开讲城市</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${classidInfo.trainAddress}</p>
                </div>
            </div>
        </div>
    </div>
</div>
<form action="staff/list.do" method="post" id="f1" class="form-inline">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>班级学员</label> <input type="text" class="form-control"
                                       name="userName" placeholder="请输入学员姓名" />
        </div>
        <input type="submit" value="查询学员" class="btn btn-success" /> <a
            href="staff/loaded.do" class="btn btn-info">添加学员</a> <input
            type="button" id="update" value="修改学员" class="btn btn-primary" /> <input
            type="button" id="delete" value="删除学员" class="btn btn-danger" />
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
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>职责</th>
                <th>公司</th>
                <th>地址</th>
                <th>电话</th>
                <th>已付</th>
            </tr>
            <c:forEach items="${list }" var="customer">
                <tr>
                    <td><input type="checkbox" id="ids" name="customerId" value="${customer.customerId}"  /></td>
                    <td>${customer.customerId}</td>
                    <td>${customer.customerName }</td>
                    <td>${customer.customerSex }</td>
                    <td>${customer.customerDuty}</td>
                    <td>${customer.customerCompany}</td>
                    <td>${customer.customerLocation}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.payMoney}</td>
                </tr>
            </c:forEach>

        </table>

    </div>
    <div align="right" style="padding: 10px;">
      <%--  <pg:pager items="${total }" url="class/showclass_list.do" maxIndexPages="3"
                  export="currentPageNumber=pageNumber" scope="request">
            <pg:param name="customerName" value="${customerName }" />
            <jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
        </pg:pager>--%>
    </div>
</form>
</body>
</html>