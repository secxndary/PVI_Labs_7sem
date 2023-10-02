<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-3</title>
</head>
<h1>PVI-3</h1>
<br/>

<form action="sss-servlet" method="GET">
    <input type="submit" value="GET Sss" />
</form>
<br />
<br />


<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="gggDispatcher" hidden />
    <input type="submit" value="Ggg dispatch" />
</form>
<br />

<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="htmlDispatcher" hidden />
    <input type="submit" value="Html dispatch" />
</form>
<br />

<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="tripleDispatcher" hidden />
    <input type="submit" value="Triple dispatch" />
</form>
<br />
<br />
<br />


<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="gggRedirect" hidden />
    <input type="submit" value="Ggg redirect" />
</form>
<br />

<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="htmlRedirect" hidden />
    <input type="submit" value="Html redirect" />
</form>
<br />

<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="tripleRedirect" hidden />
    <input type="submit" value="Triple redirect" />
</form>
<br />
<br />
<br />


<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="httpClientLocal" hidden />
    <input type="submit" value="HTTP client (GET local)" />
</form>
<br />

<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="httpClientRemote" hidden />
    <input type="submit" value="HTTP client (GET remote)" />
</form>
<br />

<form action="sss-servlet" method="POST">
    <input name="redirectType" type="text" value="httpClientLocalPost" hidden />
    <input type="submit" value="HTTP client (POST local)" />
</form>
<br />

</body>
</html>