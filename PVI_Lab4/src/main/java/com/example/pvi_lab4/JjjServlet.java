package com.example.pvi_lab4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "jjjServlet", value = "/jjj-servlet")
public class JjjServlet extends HttpServlet {
    public void init() { }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "LOX" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}