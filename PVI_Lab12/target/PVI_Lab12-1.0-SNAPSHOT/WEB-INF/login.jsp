<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="j_security_check">
    <label for="username">Username</label>  <br />
    <input id="username" type="text" name="j_username" /> <br />

    <label for="password">Password</label>  <br />
    <input id="password" type="password" name="j_password" /> <br />

    <input type="submit" value="Sign in"/>
</form>

</body>
</html>