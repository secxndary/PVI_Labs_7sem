package com.example.pvi_lab12;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sssServlet", value = "/sss-servlet")
public class SssServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.getWriter().println("<h1>Welcome! Sss Servlet</h1>");
    }
}
