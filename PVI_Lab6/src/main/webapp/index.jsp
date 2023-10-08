<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-6</title>
</head>
<body>
<h1>PVI-6</h1>

<p><a href="url-servlet?urln=1">URLn Servlet (URL1)</a></p>
<p><a href="url-servlet?urln=2">URLn Servlet (URL2)</a></p>

<p>URL1 = <%=pageContext.getServletContext().getInitParameter("URL1")%> </p>
<p>URL2 = <%=pageContext.getServletContext().getInitParameter("URL2")%> </p>
</body>
</html>