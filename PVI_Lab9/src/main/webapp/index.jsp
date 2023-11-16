<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-9</title>
</head>
<body>
<h1>PVI-9</h1>


<h2>Session Attribute</h2>

<form action="ccc-servlet?CBean=new&attributeType=session" method="POST">
    <label for="value1-session">Value 1</label>
    <input id="value1-session" name="value1" type="text" /> <br />

    <label for="value2-session">Value 2</label>
    <input id="value2-session" name="value2" type="text" /> <br />

    <label for="value3-session">Value 3</label>
    <input id="value3-session" name="value3" type="text" /> <br />

    <input type="submit" value="Ccc Servlet" />
</form>

</body>
</html>