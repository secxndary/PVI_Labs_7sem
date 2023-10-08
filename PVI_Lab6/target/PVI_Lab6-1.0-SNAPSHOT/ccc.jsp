<%@ page import="com.example.pvi_lab6.utils.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ccc</title>
</head>
<body>
<%
    Object atrCBean = application.getAttribute("atrCBean");
    String cBeanParameter = (String) session.getAttribute("cBeanParameter");
    CBean cBean = (CBean) session.getAttribute("cBean");
%>

    <h1>CBean: <%=cBeanParameter%></h1>
    <h2>AtrCBean: <%=atrCBean%> </h2>

    <h3>Value1 = <%=cBean.getValue1()%> </h3>
    <h3>Value2 = <%=cBean.getValue2()%> </h3>
    <h3>Value3 = <%=cBean.getValue3()%> </h3>

</body>
</html>
