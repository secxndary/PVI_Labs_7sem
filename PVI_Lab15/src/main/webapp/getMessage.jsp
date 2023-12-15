<%@ page import="jakarta.mail.MessagingException" %>
<%@ page import="com.example.pvi_lab15.ReadEmail" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>
<%
    try
    {
        out.println(ReadEmail.getMessage(
                application.getInitParameter("sender_email"),
                application.getInitParameter("sender_email_password"),
                request.getParameter("date"))
        );
    }
    catch (MessagingException e)
    {
        e.printStackTrace();
    }
%>
<a href="message-form.html">Message</a>
</body>
</html>