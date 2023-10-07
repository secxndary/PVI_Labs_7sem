<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.FileWriter" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<%String greetingNight = "Night";%>
<head>
    <title><%=greetingNight%></title>
</head>
<body>
<h1><%=greetingNight%> Page</h1>
<%
    try {
        String logFile = "C:\\Users\\valda\\source\\repos\\semester#7\\ПвI\\PVI_Lab4\\logs\\stdout.txt";
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String logMessage = "[INFO] " + dateTimeFormat.format(Calendar.getInstance().getTime()) + " – " + greetingNight;
        PrintWriter writer = new PrintWriter(new FileWriter(logFile, true));
        writer.println(logMessage);
        writer.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>
