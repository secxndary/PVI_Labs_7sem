package com.example.pvi_lab11.servlets;

import com.example.pvi_lab11.utils.ConsoleColors;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sssHeaderServlet", value = "/sss-header")
public class SssHeaderServlet extends HttpServlet implements Servlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(ConsoleColors.GREEN + "[HEADER]\tinit()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println(ConsoleColors.BLUE + "[HEADER]\tservice()");

        try {
            int x = req.getHeader("value-x") != null ? Integer.parseInt(req.getHeader("value-x")) : 0;
            int y = req.getHeader("value-y") != null ? Integer.parseInt(req.getHeader("value-y")) : 0;
            int z = x + y;

            res.setHeader("value-z", Integer.toString(z));

            Thread.sleep(1000);

        } catch (Exception e) {
            res.getWriter().println(e.getMessage());
        }
    }
}