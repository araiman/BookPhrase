<%--
  Created by IntelliJ IDEA.
  User: RyomaArai
  Date: 15/03/16
  Time: 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
    <link rel="stylesheet" href="../../res/css/timeline.css">
    <title>ブクフレ</title>
</head>
<body>
<div id="page">
    <jsp:include page="header.jsp"></jsp:include>
    <div id="main">
        <c:forEach var="post" items="${latestTlList}" varStatus="status">
            <section class="bookPhrase">
                <p><a name="post${status.count}" href="">${post.phrase}</a></p>
            </section>
        </c:forEach>
        <p><a href="/TlServlet?postcount=${fn:length(latestTlList)}#post${fn:length(latestTlList)}">さらに表示する</a></p>
    </div>
    <!-- #main -->
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<!-- #page -->
</body>
</html>
