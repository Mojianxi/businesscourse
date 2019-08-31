<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script src="res/js/highcharts.js" type="text/javascript"></script>
    <script src="res/js/jquery.highchartTable.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $('table.highchart').highchartTable();
        });
    </script>
</head>
<body>

<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="padding: 0px; padding-left: 20px;">
        <li><a href="#">首页</a></li>
        <li>工作台</li>
    </ul>
</div>

<div class="row " style="padding: 1px; margin: 0px;">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading" style="padding: 3px; height: 30px;">
                <span class="glyphicon glyphicon-refresh"></span>薪资发放统计
            </div>
            <div class="panel-body">
                <table class="highchart" data-graph-container-before="1"
                       data-graph-type="line" data-graph-height="350"
                       style="display: none">
                    <thead>
                    <tr>
                        <th>月份</th>
                        <th>发放金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${salarylist }" var="s">
                        <tr>
                            <td>${s.mdate }</td>
                            <td>${s.total }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading" style="padding: 3px; height: 30px;">
                <span class="glyphicon glyphicon-refresh"></span>公司业绩统计
            </div>
            <table class="highchart" data-graph-container-before="1"
                   data-graph-type="pie" data-graph-height="350"
                   style="display: none">
                <thead>
                <tr>
                    <th>月份</th>
                    <th>发放金额</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${salarylist }" var="s">
                    <tr>
                        <td>${s.mdate }</td>
                        <td>${s.total }</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading" style="padding: 3px; height: 30px;">
                <span class="glyphicon glyphicon-refresh"></span>费用统计
            </div>
            <div class="panel-body">
                <table class="highchart" data-graph-container-before="1"
                       data-graph-type="column" data-graph-height="350"
                       style="display: none">
                    <thead>
                    <tr>
                        <th>月份</th>
                        <th>报销金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${expenselist }" var="s">
                        <tr>
                            <td>${s.mdate }</td>
                            <td>${s.total }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading" style="padding: 3px; height: 30px;">
                <span class="glyphicon glyphicon-refresh"></span>报销统计
            </div>
            <table class="highchart" data-graph-container-before="1"
                   data-graph-type="spline" data-graph-height="350"
                   style="display: none">
                <thead>
                <tr>
                    <th>月份</th>
                    <th>报销金额</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${expenselist }" var="s">
                    <tr>
                        <td>${s.mdate }</td>
                        <td>${s.total }</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="col-sm-6">
    <div class="panel panel-default">
        <div class="panel-heading" style="padding: 3px; height: 30px;">
            <span class="glyphicon glyphicon-refresh"></span>课程销售统计
        </div>
        <div class="panel-body">
            <table class="table ">
              <%--  <tr>

                    <th>报销编号</th>
                    <th>报销原因</th>
                    <th>报销人</th>
                    <th>报销时间</th>
                    <th>报销总金额</th>
                    <th>审核</th>
                </tr>--%>

                <c:forEach items="${managerlist }" var="exp">
                    <tr>

                        <td>${exp.expenseId }</td>
                        <td>${exp.expenseName }</td>
                        <td>${exp.userName }</td>
                        <td><fmt:formatDate value="${exp.expenseTime }" type="date"/></td>
                        <td>￥${exp.expenseTotal }</td>
                        <th><a href="expense/loadManager.do?expenseId=${exp.expenseId }">审核</a></th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<div class="col-sm-6">
    <div class="panel panel-default">
        <div class="panel-heading" style="padding: 3px; height: 30px;">
            <span class="glyphicon glyphicon-refresh"></span>个人业绩统计
        </div>
        <div class="panel-body">
            <table class="table ">
                <%--<tr>

                    <th>报销编号</th>
                    <th>报销原因</th>
                    <th>报销人</th>
                    <th>报销时间</th>
                    <th>报销总金额</th>
                    <th>审核</th>
                </tr>--%>

                <c:forEach items="${financelist }" var="exp">
                    <tr>

                        <td>${exp.expenseId }</td>
                        <td>${exp.expenseName }</td>
                        <td>${exp.userName }</td>
                        <td><fmt:formatDate value="${exp.expenseTime }" type="date"/></td>
                        <td>￥${exp.expenseTotal }</td>
                        <th><a href="expense/loadFinance.do?expenseId=${exp.expenseId }">审核</a></th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</body>
</html>