package com.example.pvi_lab11.servlets;

import com.example.pvi_lab11.utils.ConsoleColors;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "sssJsonServlet", value = "/sss-json")
public class SssJsonServlet extends HttpServlet implements Servlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(ConsoleColors.GREEN + "[JSON]\t\tinit()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println(ConsoleColors.CYAN + "[JSON]\t\tservice()");

        try {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(req.getHeader("XRand-N"));
            int count = random.nextInt(6) + 5;

            sb.append("[");
            for (int i = 0; i < count; i++) {
                int number = random.nextInt(n * 2) - n;
                sb.append(number).append(i < count -1 ? "," : "");
            }
            sb.append("]");

            res.setContentType("application/json");
            res.getWriter().println(sb);

            Thread.sleep(1000);

        } catch (Exception e) {
            res.getWriter().println(e.getMessage());
        }
    }
}