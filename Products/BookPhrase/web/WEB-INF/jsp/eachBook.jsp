<%--
  Created by IntelliJ IDEA.
  User: RyomaArai
  Date: 15/04/05
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="page">
    <jsp:include page="../../WEB-INF/jsp/header.jsp"></jsp:include>
    <div id="main">
        <section id="leftColumn">
            <a href="${bookInfo.detailPageURL}"><img src="${bookInfo.imgAddress}"></a>

            <p><a href="${bookInfo.detailPageURL}#pd-available">あらすじ</a></p>
        </section>
        <section id="rightColumn">
            <c:forEach var="post" items="${eachBookPostsList}" varStatus="status">
                <p><a name="post${status.count}">${post.phrase}</a></p>
            </c:forEach>
            <p>
                <a href="/EachBookServlet?post-count=${fn:length(eachBookPostsList)}&isbn-str=${bookInfo.isbn_str}#post${fn:length(eachBookPostsList)}">さらに表示する</a>
            </p>
        </section>
    </div>
    <!-- #main -->
    <jsp:include page="../../WEB-INF/jsp/footer.jsp"></jsp:include>
</div>
<!-- #page -->

</body>
</html>
