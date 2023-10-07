package com.example.pvi_lab5;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "tttServlet", value = "/ttt-servlet")
public class TttServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String requestMethod = req.getMethod();
        String surname = req.getParameter("surname");
        String lastname = req.getParameter("lastname");
        String sex = req.getParameter("sex");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>TttServlet</h1>");
        out.println("<h2>Request method: " + requestMethod + "</h2>");
        out.println("<h3>Surname: " + surname + "</h3>");
        out.println("<h3>Lastname: " + lastname + "</h3>");
        out.println("<h3>Sex: " + sex + "</h3>");
        out.println("</body></html>");
    }
}