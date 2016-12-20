<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tagTable" tagdir="/WEB-INF/tags" %>

<html>
<body>

<%@include file="initConnection.jsp"%>
<!-- user es el nombre del tag, se le pasa por "EL" el requestScope de la key de la lista -->
<tagTable:table user="${requestScope.lista}"></tagTable:table>

</body>
</html>
