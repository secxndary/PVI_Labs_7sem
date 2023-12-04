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

@WebServlet(name = "sssXmlServlet", value = "/sss-xml")
public class SssXmlServlet extends HttpServlet implements Servlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(ConsoleColors.GREEN + "[XML]\t\tinit()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println(ConsoleColors.PURPLE + "[XML]\t\tservice()");

        try {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(req.getHeader("XRand-N"));
            int count = random.nextInt(6) + 5;

            sb.append("<?xml version=\"1.0\"  encoding = \"utf-8\" ?>");
            sb.append("<rand>");
            for (int i = 0; i < count; i++) {
                int number = random.nextInt(n * 2) - n;
                sb.append("<num>").append(number).append("</num>");
            }
            sb.append("</rand>");

            res.setContentType("text/xml");
            res.getWriter().println(sb);

            Thread.sleep(1000);

        } catch (Exception e) {
            res.getWriter().println(e.getMessage());
        }
    }
}
