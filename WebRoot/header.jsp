<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="container-fluid">

	<div class="col-md-9">
		<img src="Imag/logo2.png" />
	</div>
	
	
	<div class="col-md-3" style="padding-top:30px">
		<ol class="list-inline">
		
		<c:if test="${empty user }">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
		</c:if>
		
		<c:if test="${!empty user }">
			<li>欢迎您:${user.username }</li>
			<li><a href="#">退出</a></li>
		</c:if>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="#">帮助中心</a></li>
		</ol>
	</div>
</div>

