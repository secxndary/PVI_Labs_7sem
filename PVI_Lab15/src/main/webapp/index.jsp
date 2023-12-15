<%@ page import="jakarta.mail.MessagingException" %>
<%@ page import="com.example.pvi_lab15.ReadEmail" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>

<h1><% application.getInitParameter("sender_email"); %> messages</h1>
<%
    try
    {
        out.println(ReadEmail.showMessages(
                application.getInitParameter("sender_email"),
                application.getInitParameter("sender_email_password")
        ));
    }
    catch (MessagingException e)
    {
        out.println(e.getMessage());
    }
%>
</body>
</html>