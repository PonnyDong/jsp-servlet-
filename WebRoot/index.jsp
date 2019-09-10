<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--引入jstl核心标签  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>零食网</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="container-fluid">
			<!-- 引入header.jsp -->
			<jsp:include page="/header.jsp"></jsp:include>
			<div >
			<div>
				<a class="navbar-brand" href="#" background-color="cyan">首页</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">坚果炒货</a></li>
					<li><a href="#">饼干糕点</a></li>
					<li><a href="#">糖果巧克力</a></li>
					<li><a href="#">蜜饯果干</a></li>
					<li><a href="#">膨化零食</a></li>
					<li><a href="#">饮料</a></li>
					<li><a href="#">特产零食</a></li>
					<li><a href="#">进口零食</a></li>
					<li><a href="#">罐头</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="搜索">
					</div>
					<button type="submit" class="btn btn-default">点击搜索</button>
				</form>
		<!-- 	</div>
		</div> -->
</div>

			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="Imag/1.jpg">
							<div class="carousel-caption">
							</div>
						</div>
						<div class="item">
							<img src="Imag/2.jpg">
							<div class="carousel-caption">
							</div>
						</div>
						<div class="item">
							<img src="Imag/3.jpg">
							<div class="carousel-caption">
							</div>
						</div>
					</div>

					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>特价优惠&nbsp;&nbsp;</h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="Imag/bg00.png" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<c:forEach items="${discProductList }" var="discPro">
						<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
							<a href="${pageContext.request.contextPath }/productInfo?pid=${discPro.pid}">
								<img src="${pageContext.request.contextPath }/${discPro.pimage }" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="${pageContext.request.contextPath }/productInfo?pid=${discPro.pid}" style='color:#666'>${discPro.pname }</a></p>
							<p><font color="red" style="font-size:15px">&yen;${discPro.disc_price}</font></p>
					</div>
					</c:forEach>
				</div>
			</div>
			
            <div class="container-fluid">
				<img src="Imag/ad.png" width="100%"/>
			</div>

			
			<!-- 引入footer.jsp -->
			<jsp:include page="/footer.jsp"></jsp:include>
			
		</div>
	</body>

</html>