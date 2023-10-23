<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-7</title>
</head>
<body>
<h1>PVI-7</h1>


<br />
<h2>Request Attribute</h2>
<p><a href="ccc-servlet?CBean=old&attributeType=request">Ccc Servlet (old)</a></p>
<p><a href="ccc-servlet?CBean=new&attributeType=request">Ccc Servlet (new)</a></p>
<br />

<form action="ccc-servlet?CBean=new&attributeType=request" method="POST">
    <label for="value1-request">Value 1</label>
    <input id="value1-request" name="value1" type="text" /> <br />

    <label for="value2-request">Value 2</label>
    <input id="value2-request" name="value2" type="text" /> <br />

    <label for="value3-request">Value 3</label>
    <input id="value3-request" name="value3" type="text" /> <br />

    <input type="submit" value="Ccc Servlet (new with values)" />
</form>
<br />
<br />
<br />



<h2>Session Attribute</h2>
<p><a href="ccc-servlet?CBean=old&attributeType=session">Ccc Servlet (old)</a></p>
<p><a href="ccc-servlet?CBean=new&attributeType=session">Ccc Servlet (new)</a></p>
<br />

<form action="ccc-servlet?CBean=new&attributeType=session" method="POST">
    <label for="value1-session">Value 1</label>
    <input id="value1-session" name="value1" type="text" /> <br />

    <label for="value2-session">Value 2</label>
    <input id="value2-session" name="value2" type="text" /> <br />

    <label for="value3-session">Value 3</label>
    <input id="value3-session" name="value3" type="text" /> <br />

    <input type="submit" value="Ccc Servlet (new with values)" />
</form>

</body>
</html>