package com.example.pvi_lab3;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sssServlet", value = "/sss-servlet")
public class SssServlet extends HttpServlet {

    public void init() {
        System.out.println(ConsoleColors.GREEN + "[SSS] init()");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(ConsoleColors.PURPLE + "[SSS] doGet\n");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println(ConsoleColors.CYAN + "[SSS] service\n");

        String requestType = req.getMethod();

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>Service: SSS</h1>");
        out.println("<h3>Request type: " + requestType + "</h3>");
        out.println("</body></html>");


//        res.sendRedirect("ggg-servlet");
    }

    public void destroy() {
        System.out.println(ConsoleColors.YELLOW + "[SSS] destroy");
    }
}