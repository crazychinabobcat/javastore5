<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>关于我们</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="css/style.css" type="text/css"/>
	</head>

	<body>

		<div class="container">

			<%--包含导航条 --%>
			 <%@include file="/jsp/header.jsp" %>

			<div class="container">
				<h1>${msg}</h1>
					</div>
				</div>

		<%--页脚 --%>
		<%@include file="/jsp/footer.jsp" %>

	</body>

</html>