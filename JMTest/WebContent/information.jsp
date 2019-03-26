<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Mes.information"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基本信息</title>
<style type="text/css">
	table {
		cellspacing:0;
		border-collapse:collapse;
		cellpading:0;
	}
	a{text-decoration:none;color: blue}
#find{width: 624px;height: 36px;display: block;float: left;}
</style>
<script src="echarts.js"></script>
</head>
<body>
<h1 align="center">基本信息</h1>
<div style="width: 80%;margin: 0 auto;">
	
	
	<c:forEach items="${sessionScope.needBeans}" var="pro">
	<div style="border: 1px;border-color: black;margin:20px auto;height: 174px;width: 867px">
			<div id="left" style="border: 1px;float: left; border-color: black;width: 228px;height: 181px"><br/>
				<div style="margin-left: 25px;margin-top: 20px">
					<font style="font-size: 20px" color="blue"></font>
				</div>
			</div>
			<div id="right" style="border: 1px;float: left; border-color: black;height: 181px">
				<table style="border: 1px">
					<tr height="48px">
						<td  style="width: 270px">
						<span style="font-size: 15px;font-family: '黑体'">
						
						<h3><a href="">${pro.CORP_NAME}</a></h3>
						
					
						</span></td>
						<td>
						<span style="font: blue">在业</span>
						</td>
						</tr>
					<tr height="38px"><td>电话:${pro.TEL}</td></tr>
					<tr height="38px"><td>官网:${pro.WEB_URL}</td><td>邮箱:${pro.EMAIL}</td></tr>
					<tr height="38px"><td>地址:${pro.ADDR}</td><td><font color="blue">附近公司</font></td></tr>
				</table>
			</div>
		</div>
		
		<div>
		<table style="text-align: center;" id="info" border="1" align="center" width="80%">
			<tr height="45px">
				<td>经营状态</td><td>${pro.CORP_STATUS}</td>
				<td>统一社会信用代码</td><td>${pro.REG_NO}</td>
			</tr>
			<tr height="45px">
				<td>纳税人识别号</td><td>${pro.TAXPAY_NUM}</td>
				<td>注册号</td><td>${pro.UNI_SCID}</td>
			</tr>
			<tr height="45px">
				<td>组织机构代码</td><td>${pro.ORG_INST_CODE}</td>
				<td>公司类型</td><td>${pro.ECON_KIND}</td>
			</tr>
			<tr height="45px">
				<td>人员规模</td><td>${pro.STAFF_SIZE}</td>
				<td>营业期限</td><td>${pro.FARE_TERM_START}--${pro.FARE_TERM_END}</td>
			</tr>
			<tr height="45px">
				<td>登记机关</td><td>${pro.BELONG_ORG}</td>
				<td>核准日期</td><td>${pro.CHECK_DATE}</td>
			</tr>
			<tr height="45px">
				<td>英文名</td><td>${pro.ENGLISH_NAME}</td>
				<td>曾用名</td><td>${pro.FORMER_NAME}</td>
			</tr>
			<tr height="45px">
				<td>所属地区</td><td>${pro.BELONG_DIST_ORG}</td>
				<td>所属行业</td><td>${pro.BELONG_TRADE}</td>
			</tr>
			<tr height="45px">
				<td>企业地址</td><td>${pro.ADDR}</td>
				<td>经营范围</td><td>${pro.FARE_SCOPE}</td>
			</tr>			
		</table>
		</div>
		</c:forEach>
	
<!-- -------------------------------------------------公司信息结束-------------------------------------------- -->

		

</body>
</html>
