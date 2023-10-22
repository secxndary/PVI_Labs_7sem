<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-7</title>
</head>
<body>
<h1>PVI-7</h1>

<p><a href="ccc-servlet?CBean=old">Ccc Servlet (old)</a></p>
<p><a href="ccc-servlet?CBean=new">Ccc Servlet (new)</a></p>
<br />


<form action="ccc-servlet?CBean=new" method="POST">
    <label for="value1">Value 1</label>
    <input id="value1" name="value1" type="text" /> <br />

    <label for="value2">Value 2</label>
    <input id="value2" name="value2" type="text" /> <br />

    <label for="value3">Value 3</label>
    <input id="value3" name="value3" type="text" /> <br />

    <input type="submit" value="Ccc Servlet (new with values)" />
</form>
<br />

</body>
</html>