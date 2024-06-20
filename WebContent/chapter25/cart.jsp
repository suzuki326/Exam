<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">寿司オンラインショッピング</c:param>

<c:param name="body">


<c:choose>
	<c:when  test="${session_cart.size()>0}">
		<p>${session_cart.size()}種類の商品があります。</p>
		<hr>
	</c:when>
	<c:otherwise>
		<p>カートに商品がありません。</p>
	</c:otherwise>
</c:choose>

<table style="border-collapse:separate;border-spacing:10px;">
<c:forEach var="item" items="${session_cart}">
	<tr>
	<td>商品${item.product.id}</td>
	<td><img src="image/${item.product.image}" height="96"></td>
	<td>${item.product.name}</td>
	<td>${item.product.price}円</td>
	<td>${item.count}個</td>
	<td><a href="cart-remove?id=${item.product.id}">カートから削除</a></td>
	</tr>
</c:forEach>
</table>

</c:param>

</c:import>