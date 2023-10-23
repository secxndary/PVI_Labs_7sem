<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-8</title>
</head>
<body>
<h1>PVI-8</h1>
<br/>

<form action="aaa-servlet" method="POST">
    <label for="name1">Name 1</label>
    <input id="name1" name="name1" type="text" placeholder="X-..." />
    <label for="value1">Value 1</label>
    <input id="value1" name="value1" type="text" /> <br />

    <label for="name2">Name 2</label>
    <input id="name2" name="name2" type="text" placeholder="X-..." />
    <label for="value2">Value 2</label>
    <input id="value2" name="value2" type="text" /> <br />

    <label for="name3">Name 3</label>
    <input id="name3" name="name3" type="text" placeholder="X-..." />
    <label for="value3">Value 3</label>
    <input id="value3" name="value3" type="text" /> <br /><br />

    <input type="submit" value="Aaa Servlet" />
</form>

</body>
</html>