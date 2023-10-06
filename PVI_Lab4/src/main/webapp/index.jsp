<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PVI-4</title>
</head>
<body>
<h1>PVI-4</h1>
<%
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    int hourOfDay = calendar.get(java.util.Calendar.HOUR_OF_DAY);
    String greeting;


    // ====================================  Приветствие  =====================================
    if (hourOfDay >= 0 && hourOfDay < 12)
        greeting = "Good morning";
    else if (hourOfDay >= 12 && hourOfDay < 17)
        greeting = "Good afternoon";
    else if (hourOfDay >= 17 && hourOfDay < 20)
        greeting = "Good evening";
    else
        greeting = "Good night";
    out.println("<h2>"  + greeting + "</h2>");


    // ===============================  Таблица с днями недели  ===============================
    out.println("<table border='1' style=\"border-collapse: collapse\">");
    out.println("<tr><th>Date</th><th>Day of Week</th></tr>");

    for (int i = 0; i < 7; i++) {
        out.println("<tr>");
        out.println("<td>" + dateFormat.format(calendar.getTime()) + "</td>");

        int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1)
            dayOfWeek = 7;
        else
            dayOfWeek--;

        out.println("<td>" + dayOfWeek + "</td>");
        out.println("</tr>");
        calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
    }
    out.println("</table>");
    out.println("<br/>");


    // ==================================  Кнопка Press  ==================================
    String[] words = greeting.split(" ");
    String jspName = words[words.length - 1];

    out.println("<form action=\"" + jspName + ".jsp\">" +
                "<input type=\"submit\" value=\"Press\">" +
                "</form>");

%>

<%@ include file="night.jsp" %>
<%--<jsp:include page="night.jsp" />--%>

</body>
</html>