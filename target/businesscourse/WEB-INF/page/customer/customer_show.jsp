<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客户详情</title>
    <link rel="stylesheet" href="res/css/bootstrap.css">
    <script type="text/javascript" src="res/js/jquery.min.js"></script>
    <script type="text/javascript" src="res/js/bootstrap.min.js"></script>

</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="margin: 0px; padding-left: 20px;">
        <li>营销管理</li>
        <li>客户管理</li>
        <li>客户详情</li>

    </ul>
</div>
<form action="" method="post" class="form-horizontal">
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">客户基本信息</h5>
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">客户姓名</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${customer.customerName }</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">客户性别</label>
                <div class="col-sm-5">
                    <p class="form-control-static">${customer.customerSex}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">客户职位</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${customer.customerDuty }</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">客户公司</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${customer.customerCompany}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">客户地址</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${customer.customerLocation}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">客户电话</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${customer.customerPhone}</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">客户微信</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${customer.customerWechat}</p>
                </div>
            </div>
        </div>
    </div>
    <h5 class="page-header alert-info"
        style="margin: 0px; padding: 10px; margin-bottom: 10px">客户订单信息</h5>
    <table class="table" id="tab1e">
        <tr>
            <th>课程名称</th>
            <th>课程价格</th>
            <th>服务员工</th>
            <th>订单状况</th>
            <th>支付金额</th>
            <th>支付时间</th>
        </tr>
        <c:forEach items="${list }" var="cfc">
            <tr>
                <td>${cfc.courseName}</td>
                <td>${cfc.coursePrice}</td>
                <td>${cfc.staffName}</td>
                <td>
                        ${cfc.relevType=='1'?'有意向':''}
                        ${cfc.relevType=='2'?'已付款':''}
                        ${cfc.relevType=='0'?'未知':''}
                </td>
                <td>${cfc.payMoney}</td>
                <td><fmt:formatDate value="${cfc.payTime}" type="both"/></td>
                <td><a href="customer/loadeditrelev.do?cfcId=${cfc.cscId}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
    <div class="row">
        <div class="col-sm-10" align="center">
            <%--<a href="user/loadupdate.do?customerId=${customer.customerId}"
               class="btn btn-primary">修改客户信息</a> --%>
            <a href="customer/list.do"
                                                     class="btn btn-danger">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>