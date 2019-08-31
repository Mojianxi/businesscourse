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
    <title>客户查询</title>
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
                    f1.attr("action", "customer/loadupdate.do");
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
                    f1.attr("action", "customer/delete.do");
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
        <li>客户管理</li>
        <li>客户查询</li>
    </ul>
</div>
<form action="staff/list.do" method="post" id="f1" class="form-inline">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>客户姓名</label> <input type="text" class="form-control"
                                       name="customerName" placeholder="请输入客户姓名" />
            <label>客户地区</label>
            <input type="text" class="form-control"
            name="customerName" placeholder="请输入客户所属区域" />
            <label>付款时间</label> <input
                type="text" class="form-control" name="expenseTime"
                placeholder="请输入付款时间" onclick="WdatePicker()" />
        </div>
        <input type="submit" value="查询客户" class="btn btn-success" /> <a
            href="customer/loaded.do" class="btn btn-info">添加用户</a>
       <%-- <input type="button" id="update" value="修改客户" class="btn btn-primary" />
        <input
            type="button" id="delete" value="删除客户" class="btn btn-danger" />--%>
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
                <th>意向</th>
                <th>到账</th>
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
                    <td>${customer.payCourseNum}</td>
                    <td>${customer.purposeCourseNum}</td>
                    <td>${customer.payMoney}</td>
                    <td><a href="customer/showcustomer.do?customerId=${customer.customerId}">查看</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div align="right" style="padding: 10px;">
        <pg:pager items="${total }" url="customer/list.do" maxIndexPages="3"
                  export="currentPageNumber=pageNumber" scope="request">
            <pg:param name="customerName" value="${customerName }" />
            <jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
        </pg:pager>
    </div>
</form>
</body>
</html>