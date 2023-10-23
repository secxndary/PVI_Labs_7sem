<%@ page import="com.example.pvi_lab6.utils.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ccc</title>
</head>
<body>
<%
    CBean atrCBean = (CBean) application.getAttribute("atrCBean");
    String cBeanParameter = (String) session.getAttribute("cBeanParameter");
%>

    <h1>CBean: <%=cBeanParameter%></h1>
    <h2>AtrCBean: <%=atrCBean%> </h2>

    <h3>Value1 = <%= atrCBean != null ? atrCBean.getValue1() : "" %> </h3>
    <h3>Value2 = <%= atrCBean != null ? atrCBean.getValue2() : "" %> </h3>
    <h3>Value3 = <%= atrCBean != null ? atrCBean.getValue3() : "" %> </h3>

</body>
</html>
