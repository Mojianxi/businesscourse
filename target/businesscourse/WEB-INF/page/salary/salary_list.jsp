<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>薪资发放查询</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="<%=basePath%>res/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>薪资管理</li>
        <li>薪资发放查询</li>

    </ul>
</div>
<div class="alert alert-warning alert-dismissible"
     style="display: ${errorinfo==null?'none':'block' };" role="alert">
    <button type="button" class="close" data-dismiss="alert"
            aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <div align="center" style="color: red;">${errorinfo }</div>
</div>
<form action="salary/list.do" method="post" id="f1" class="form-inline">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>领取人</label> <input type="text" class="form-control"
                                      name="userName" placeholder="请输入领取人"
                                      value="${salaryInfo.staffName }" /> <label>发放时间</label> <input
                type="text" class="form-control"
                value='<fmt:formatDate value="${salaryInfo.salaryDate}" type="date"/>'
                name="paymentTime" onclick="WdatePicker()" placeholder="请输入发放时间" />
        </div>
        <input type="submit" value="查询" class="btn btn-success" /> <input
            type="button" value="导入Excel" data-toggle="modal"
            data-target="#myModal" class="btn btn-success" />
    </div>

    <div class="row" style="padding: 15px;">
        <table class="table ">
            <tr>

                <th>编号</th>
                <th>领取人</th>
                <th>发放时间</th>
                <th>发放金额</th>
                <th>发放绩效</th>
                <th>发放提成</th>

            </tr>
            <c:forEach items="${list }" var="salary">
                <tr>
                    <td>${salary.salaryId}</td>
                    <td>${salary.staffName }</td>
                    <td><fmt:formatDate value="${salary.salaryDate}" type="date" /></td>
                    <td>￥${salary.salaryBasic}</td>
                    <td>￥${salary.meritPay}</td>
                    <td>￥${salary.royaltyPay}</td>
                </tr>
            </c:forEach>

        </table>

    </div>
    <div align="right" style="padding: 10px;">
        <pg:pager items="${total }" url="salary/list.do" maxIndexPages="3"
                  export="currentPageNumber=pageNumber" scope="request">
            <pg:param name="staffName" value="${salary.staffName }" />

            <jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
        </pg:pager>
    </div>
</form>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="salary/impexcel.do" method="post" enctype="multipart/form-data">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">导入薪资发放记录</h4>
                </div>
                <div class="modal-body">
                    <input type="file" name="file" />

                </div>
                <div class="modal-footer">
                    <button type="submit" id="selected" class="btn btn-primary">导入</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>