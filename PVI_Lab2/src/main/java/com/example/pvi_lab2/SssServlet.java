package com.example.pvi_lab2;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sssServlet", value = "/sss-servlet")
public class SssServlet extends HttpServlet {

    public void init() {
        System.out.println(ConsoleColors.GREEN + "[INFO] init()");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(ConsoleColors.CYAN + "[INFO] doGet\n");

        String requestType = request.getMethod();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html><body>");
        out.println("<h1>Servlet doGet()</h1>");
        out.println("<h3>Request type: " + requestType + "</h3>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(ConsoleColors.BLUE + "[INFO] doPost\n");

        String requestType = request.getMethod();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html><body>");
        out.println("<h1>Servlet doPost()</h1>");
        out.println("<h3>Request type: " + requestType + "</h3>");
        out.println("</body></html>");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(ConsoleColors.PURPLE + "[INFO] service");
        super.service(req, res);

        String requestType = req.getMethod();
        String serverName = req.getServerName();
        String serverAddress = req.getRemoteAddr();

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String queryString = req.getQueryString();

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>Servlet service()</h1>");
        out.println("<h3>Request type: " + requestType + "</h3>");
        out.println("<h3>Server name: " + serverName + "</h3>");
        out.println("<h3>Server address: " + serverAddress + "</h3>");
        out.println("<h3>First name: " + firstName + "</h3>");
        out.println("<h3>Last name: " + lastName + "</h3>");
        out.println("<h3>Query string: " + queryString + "</h3>");
        out.println("</body></html>");
    }

    public void destroy() {
        System.out.println(ConsoleColors.YELLOW + "[INFO] destroy");
    }
}