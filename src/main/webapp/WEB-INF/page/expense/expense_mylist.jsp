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
    <title>我的报销单</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>报销管理</li>
        <li>我的报销单</li>
    </ul>
</div>
<form action="expense/mylist.do" method="post" id="f1" class="form-inline">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>报销人</label> <input type="text" class="form-control"
                                      name="userName" placeholder="请输入报销人" /> <label>报销时间</label> <input
                type="text" class="form-control" name="expenseTime"
                placeholder="请输入报销时间" onclick="WdatePicker()" />
        </div>
        <input type="submit" value="查询报销单" class="btn btn-success" />
    </div>


    <div class="row" style="padding: 15px;">
        <table class="table ">
            <tr>

                <th>报销编号</th>
                <th>报销原因</th>
                <th>报销人</th>
                <th>报销时间</th>
                <th>报销总金额</th>
                <th>状态</th>
                <th>查看明细</th>
            </tr>

            <c:forEach items="${list }" var="exp">
                <tr>

                    <td>${exp.expenseId }</td>
                    <td>${exp.expenseName }</td>
                    <td>${exp.staffName }</td>
                    <td><fmt:formatDate value="${exp.expenseTime }" type="date"/></td>
                    <td>￥${exp.expenseTotal }</td>
                    <td>
                            ${exp.expenseState=='-5'?'<a href="javascript:void(0)" class="btn btn-danger btn-xs">报销单作废</a>':''}

                            ${exp.expenseState=='1'?'<a href="javascript:void(0)" class="btn btn-info btn-xs">等待经理审核</a>':''}
                            <%-- ${exp.expenseState=='-1'?'<a href="javascript:void(0)" class="btn btn-danger btn-xs">经理审核不通过</a>':''}

                            ${exp.expenseState=='-2'?'<a href="javascript:void(0)" class="btn btn-danger btn-xs">财务审核不通过</a>':''} --%>

                            ${exp.expenseState=='2'?'<a href="javascript:void(0)" class="btn btn-success btn-xs">经理审核通过</a>':''}

                            ${exp.expenseState=='3'?'<a href="javascript:void(0)" class="btn btn-success btn-xs">财务审核通过</a>':''}

                    </td>
                    <th>
                        <a href="expense/loadupdate.do?expenseId=${exp.expenseId }" style="display:${exp.expenseState=='0'?'block':'none'}">修改报销单</a>
                        <a  href="expense/myshow.do?expenseId=${exp.expenseId }"  style="display:  ${exp.expenseState=='0'?'none':'block'};">查看明细</a></th>
                </tr>
            </c:forEach>


        </table>

    </div>
    <div align="right" style="padding: 10px;">
        <pg:pager items="${total }" url="expense/mylist.do"
                  maxIndexPages="3" export="currentPageNumber=pageNumber"
                  scope="request">
            <%-- <pg:param name="userName" value="${userName }" /> --%>

            <jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
        </pg:pager>
    </div>
</form>
</body>
</html>