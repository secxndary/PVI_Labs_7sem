<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PVI-10</title>
</head>
<h1>PVI-10</h1>

<h3>Static database request</h3>
<p><a href="database-servlet?requestType=static">Run</a></p>
<br /> <br />

<h3>Request with parameters</h3>
<form action="database-servlet">
    <div>
        <input type="number" name="param1" placeholder="Minimum price" required /> <br />
        <input type="number" name="param2" placeholder="Maximum price" required />
        <input type="text" name="requestType" value="withParams" hidden />
    </div>
    <button style="margin-top: 0.5%">Get</button>
</form>
<br /> <br />

<h3>Procedure call</h3>
<form action="database-servlet">
    <div>
        <input type="number" name="param1" placeholder="Minimum price" required /> <br />
        <input type="number" name="param2" placeholder="Maximum price" required />
        <input type="text" name="requestType" value="procedure" hidden />
    </div>
    <button style="margin-top: 0.5%">Get</button>
</form>

</body>
</html>
