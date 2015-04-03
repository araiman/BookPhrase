<%--
  Created by IntelliJ IDEA.
  User: RyomaArai
  Date: 15/04/02
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="res/css/eachBook.css">
<html>
<head>
    <title>[本の名前]- ブクフレ -</title>
</head>
<body>
<div id="page">
    <jsp:include page="WEB-INF/jsp/header.jsp"></jsp:include>
    <div id="book_info">

    </div>
    <!-- #book_info -->

    <div id="main">
        <p>hogehogeohogeohogeohgoeogoeogehogoeogoeogoeho</p>
        <!-- TODO 本ごとリストの、名前に変更する -->
        <!--
        <c:forEach var="post" items="${latestTlList}" varStatus="status">
            <section class="bookPhrase">
                <p><a name="post${status.count}" href="">${post.phrase}</a></p>
            </section>
        </c:forEach>
        <p><a href="/TlServlet?postcount=${fn:length(latestTlList)}#post${fn:length(latestTlList)}">さらに表示する</a></p>
        -->
    </div>
    <!-- #main -->
    <jsp:include page="WEB-INF/jsp/footer.jsp"></jsp:include>
</div>
<!-- #page -->
</body>
</html>
