package com.example.pvi_lab6.servlets;
import com.example.pvi_lab6.utils.CBean;
import com.example.pvi_lab6.utils.ConsoleColors;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cccServlet", value = "/ccc-servlet")
public class CccServlet extends HttpServlet {

    public CBean cBean = null;
    private ServletContext servletContext;

    public void init() {
        cBean = new CBean();
        servletContext = getServletContext();
        servletContext.setAttribute("atrCBean", cBean);
        System.out.println(ConsoleColors.GREEN + "\n[CCC] init: atrCBean = " + servletContext.getAttribute("atrCBean"));
    }

    public void service(ServletRequest req, ServletResponse res) throws IOException {

        // Query-параметр CBean. Равен либо new, либо old. В противном случае – ошибка
        String cBeanParameter = req.getParameter("CBean");
        System.out.println(ConsoleColors.CYAN + "[CCC] service: CBean = " + cBeanParameter);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if (cBeanParameter == null) {
            out.println("<h2>CBean parameter is null.</h2>");
            System.out.println(ConsoleColors.RED + "[CCC] service: CBean parameter is null\n");
            return;
        }
        if (!cBeanParameter.equalsIgnoreCase("new") && !cBeanParameter.equalsIgnoreCase("old")){
            out.println("<h2>CBean parameter should be equal to \"old\" or \"new\".</h2>");
            System.out.println(ConsoleColors.RED + "[CCC] service: CBean parameter should be equal to \"old\" or \"new\"\n");
            return;
        }


        if (cBeanParameter.equalsIgnoreCase("new")) {
            cBean = new CBean();
            servletContext.setAttribute("atrCBean", cBean);
            Object atrCBeanNew = servletContext.getAttribute("atrCBean");

            out.println("<h1>CBean: " + cBeanParameter + "</h1>");
            out.println("<h2>AtrCBean: " + atrCBeanNew + "</h2>");

            System.out.println(ConsoleColors.BLUE + "[CCC] service: atrCBean = " +
                    servletContext.getAttribute("atrCBean") + ConsoleColors.YELLOW + " (new)\n");
        }

        else if (cBeanParameter.equalsIgnoreCase("old")) {
            Object atrCBeanOld = servletContext.getAttribute("atrCBean");

            out.println("<h1>CBean: " + cBeanParameter + "</h1>");
            out.println("<h2>AtrCBean: " + atrCBeanOld + "</h2>");

            System.out.println(ConsoleColors.BLUE + "[CCC] service: atrCBean = " +
                    servletContext.getAttribute("atrCBean") + ConsoleColors.YELLOW + " (old)\n");
        }

//            String param1 = req.getParameter("value1"),
//                    param2 = req.getParameter("value2"),
//                    param3 = req.getParameter("value3");
//
//
//            if (param1 != null && param2 != null && param3 != null) {
//                cBean.setValue1(param1);
//                cBean.setValue2(param2);
//                cBean.setValue3(param3);
//
//                req.getRequestDispatcher("/Ccc.jsp").forward(req, res);
//            }
//        } else if (req.getParameter("CBean").equals("old")){ //if "old"
//            ServletContext servletContext = getServletContext();
//            System.out.println("old: " + servletContext.getAttribute("atrCBean"));
//            req.getRequestDispatcher("/Ccc.jsp").forward(req, res);
//
//        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(ConsoleColors.PURPLE + "[CCC] doGet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(ConsoleColors.PURPLE + "[CCC] doPost");
    }
}
