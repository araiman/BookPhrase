<%--
  Created by IntelliJ IDEA.
  User: RyomaArai
  Date: 15/03/16
  Time: 7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
    <link rel="stylesheet" href="../../res/css/timeline.css">
    <title>ブクフレ</title>
</head>
<body>
<div id="page">
    <div id="pageHead">
        <ul>
            <li>
                <h1 id="siteTitle">ブクフレ</h1>
            </li>
            <li>
                <!-- TODO formのaction先を指定する -->
                <form id="search
                " action="" method="post">
                    <input type="text">
                    <input type="submit" value="search">
                </form>
            </li>
            <li>
                <img src="../../res/img/mypage_32.png"/>
            </li>
        </ul>
    </div>
    <!-- #pageHead -->
    <div id="main">
        <!-- TODO TlListの中身の数だけ、繰り返し、フレーズを表示する。-->
        <c:forEach var="post" items="${latestTlList}">
            <section class="bookPhrase">
                <p><a href="">${post.phrase}</a></p>
            </section>
        </c:forEach>
        <section class="bookPhrase">
            <p><a href="">よく見ると、角丸部分からボタンがはみだしていることがわkります。IE9でグラデーションを優先したい場合は、フィルターを追加すればよい
                のですが、グラデーションしていなくてもボタンとしては機能しますので、IE9ではボタンはグラデーションしないと割り切っても問題ない
                でしょう。</a></p>
        </section>
    </div>
    <!-- #main -->
    <div id="pageFoot">
        Copyriht 2015, notnewarai.com
    </div>
</div>
<!-- #page -->
</body>
</html>
