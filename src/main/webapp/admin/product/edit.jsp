<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
</HEAD>

<body>

<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/" method="post" enctype="multipart/form-data">
	<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26">
				<strong><STRONG>编辑商品</STRONG>
				</strong>
			</td>
		</tr>

			<tr>
				<td width="25%" align="center" bgColor="#f5fafe" class="ta_01">
					商品名称：
				</td>
				<td class="ta_01" bgColor="#ffffff">

					<input type="text" name="pname" value="${pud.pname}"/>
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					是否热门：
				</td>
				<td class="ta_01" bgColor="#ffffff">

					<select name="is_hot">
						<c:if test="${pud.is_hot==1}">
						<option value="是">是</option>
						</c:if>

						<c:if test="${pud.is_hot==0}">
						<option value="否">否</option>
						</c:if>

					</select>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					市场价格：
				</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="market_price" value="${pud.shop_price}"/>
				</td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商城价格：
				</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="shop_price" value="${pud.market_price}"/>
				</td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品图片：
				</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
					<input type="file" name="upload" />
					<img src="${pageContext.request.contextPath}/${pud.pimage}">
				</td>
			</tr>
			<tr>

			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					商品描述：
				</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3">
					<textarea name="pdesc" rows="5" cols="30">${pud.pdesc}</textarea>
				</td>
			</tr>



		<tr>
			<td class="ta_01" style="WIDTH: 100%" align="center"
				bgColor="#f5fafe" colSpan="4">
				<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
					&#30830;&#23450;
				</button>

				<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

				<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
				<span id="Label1"></span>
			</td>
		</tr>

	</table>
</form>
</body>
</HTML>