<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">ログイン成功</c:param>

<c:param name="body">

こんにちは、${ session_customer.login }さん

</c:param>

</c:import>