package com.example.pvi_lab10;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "databaseServlet", value = "/database-servlet")
public class DatabaseServlet extends HttpServlet implements Servlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) {

        String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=JDBC;Trusted_Connection=No;user=sa;password=1111";
        float param1 = req.getParameter("param1") != null ? Integer.parseInt(req.getParameter("param1")) : 0;
        float param2 = req.getParameter("param2") != null ? Integer.parseInt(req.getParameter("param2")) : 999;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println(ConsoleColors.GREEN + "[OK] Connected successfully.");

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM DiningRoom where Price > ? and Price < ?");
            statement.setFloat(1, param1);
            statement.setFloat(2, param2);
            ResultSet resultSet = statement.executeQuery();

            res.setContentType("text/html;charset=utf-8");
            PrintWriter out = res.getWriter();

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
