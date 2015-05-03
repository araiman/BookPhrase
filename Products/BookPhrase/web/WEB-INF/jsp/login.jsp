<%--
  Created by IntelliJ IDEA.
  User: RyomaArai
  Date: 15/04/12
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="../../res/js/FbLogin.js"></script>
</head>
<body>
${error.errorMsg}
<br>
<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>

<div
        id="tw-login"
        >
    <a href="/TwSignInServlet">twitterログイン</a>
</div>

<form action="/LoginServlet" method= "post" id="login-with-email">
    <p>メールアドレス:
    <input type="text" name="email" size="40">
    </p>
    <p>パスワード:
    <input type="password" name="password" size="40">
    </p>
    <input type="submit">
</form>
</body>
</html>
