<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">寿司オンラインショッピング</c:param>

<c:param name="body">

<p>${session_cart.size()}種類の商品があります。</p>
<hr>

<table style="border-collapse:separate;border-spacing:10px;">
<c:forEach var="item" items="${session_cart}">
	<tr>
	<td>商品${item.product.id}</td>
	<td><img src="image/${item.product.image}" height="96"></td>
	<td>${item.product.name}</td>
	<td>${item.product.price}円</td>
	<td>${item.count}個</td>
	</tr>
</c:forEach>
</table>
<hr>

<form action="preview" method="post">
<p>お名前 <input type="text" name="name"></p>
<p>ご住所 <input type="text" name="address"></p>
<p><input type="submit" value="購入を確定"></p>
<p>${ error }</p>
</form>

</c:param>

</c:import>