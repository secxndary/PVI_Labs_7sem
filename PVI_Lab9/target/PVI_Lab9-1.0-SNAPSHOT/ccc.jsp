<%@ page import="com.example.pvi_lab9.utils.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ccc</title>
</head>
<body>
<%
    String cBeanParameter = (String) request.getAttribute("cBeanParameter");
    String attributeType = (String) request.getAttribute("attributeType");
    CBean atrCBeanSession = (CBean) session.getAttribute(session.getId());
%>

    <h1>CBean: <%=cBeanParameter%></h1>
    <h2>Attribute type: <%=attributeType%></h2>
    <br />

    <h2>AtrCBean: <%=atrCBeanSession%> </h2>
    <h3>Value1 = <%= atrCBeanSession != null ? atrCBeanSession.getValue1() : "" %> </h3>
    <h3>Value2 = <%= atrCBeanSession != null ? atrCBeanSession.getValue2() : "" %> </h3>
    <h3>Value3 = <%= atrCBeanSession != null ? atrCBeanSession.getValue3() : "" %> </h3>
</body>
</html>
