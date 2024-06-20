<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">寿司オンラインショッピング</c:param>

<c:param name="body">

<p>検索キーワードを入力してください。</p>
<form action="product" method="get">
<input type="text" name="keyword">
<input type="submit" value="検索">
</form>
<hr>

<table style="border-collapse:separate;border-spacing:10px;">
<c:forEach var="product" items="${session_list}">
	<tr>
	<td>商品${product.id}</td>
	<td><img src="image/${product.image}" height="64"></td>
	<td>${product.name}</td>
	<td>${product.price}円</td>
	<td><a href="cart-add?id=${product.id}">カートに追加</a></td>
	</tr>
</c:forEach>
</table>

</c:param>

</c:import>