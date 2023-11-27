package com.example.pvi_lab10;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "databaseServlet", value = "/database-servlet")
public class DatabaseServlet extends HttpServlet implements Servlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=JDBC;Trusted_Connection=No;user=sa;password=1111";
        ResultSet resultSet = null;

        float param1 = req.getParameter("param1") != null ? Integer.parseInt(req.getParameter("param1")) : 0;
        float param2 = req.getParameter("param2") != null ? Integer.parseInt(req.getParameter("param2")) : 999;
        String requestType = !req.getParameter("requestType").isEmpty() ? req.getParameter("requestType") : "withParams";

        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println(ConsoleColors.GREEN + "[OK] Connected successfully.");

            if (requestType.equalsIgnoreCase("static")) {
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM DiningRoom");
                resultSet = statement.executeQuery();
            }
            else if (requestType.equalsIgnoreCase("withParams")) {
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM DiningRoom where Price > ? and Price < ?");
                statement.setFloat(1, param1);
                statement.setFloat(2, param2);
                resultSet = statement.executeQuery();
            }
            else if (requestType.equalsIgnoreCase("procedure")) {
                CallableStatement callableStatement = connection.prepareCall(
                        "{call GetDishesByPriceRange(?, ?)}");
                callableStatement.setFloat(1, param1);
                callableStatement.setFloat(2, param2);
                resultSet = callableStatement.executeQuery();
                out.println("<p>Param1 = " + param1 + "</p>");
                out.println("<p>Param2 = " + param2 + "</p>");
            }
            else {
                out.println("<h3>[ERROR] Incorrect query parameter \"requestType\". Should be 'static', 'withParams' or 'procedure'.</h3>");
                return;
            }

            out.println("<style>" +
                            "table { border-collapse: collapse; }" +
                            "th, td { border: 1px solid black; padding: 5px; }" +
                        "</style>");

            out.println("<table>" +
                            "<tr>" +
                                "<th>Id</th>" +
                                "<th>Name</th>" +
                                "<th>Price</th>" +
                                "<th>Comment</th>" +
                            "</tr>");

            while (resultSet.next()) {
                out.println("<tr>" +
                                "<td>" + resultSet.getInt("Id") + "</td>" +
                                "<td>" + resultSet.getString("Name") + "</td>" +
                                "<td>" + resultSet.getFloat("Price") + "</td>" +
                                "<td>" + resultSet.getString("Comment") + "</td>" +
                            "</tr>");
            }
            out.println("</table>");

        } catch (Exception e) {
            System.out.println(ConsoleColors.YELLOW + "[ERROR] Cannot connect to the database.");
            e.printStackTrace();
        }
    }
}
