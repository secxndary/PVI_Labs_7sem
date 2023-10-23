package com.example.pvi_lab7.servlets;
import com.example.pvi_lab7.utils.CBean;
import com.example.pvi_lab7.utils.ConsoleColors;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cccServlet", value = "/ccc-servlet")
public class CccServlet extends HttpServlet {

    public CBean cBean = null;

    public void init() {
        cBean = new CBean();
    }

    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        HttpSession session = httpServletRequest.getSession();
        String sessionId = session.getId();
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Query-параметр CBean. Равен либо new, либо old. В противном случае – ошибка
        String cBeanParameter = req.getParameter("CBean");
        System.out.println(ConsoleColors.PURPLE + "[CCC] service: CBean:\t\t" + cBeanParameter);
        // Параметры value1, value2 и value3, передаваемые в POST-запросе (для установки в поля класса CBean)
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        String value3 = req.getParameter("value3");
        // Тип атрибута: запрос (пункт 7.8.3) либо сесиия (пункт 7.8.4)
        String attributeType = req.getParameter("attributeType");


        // Обработка ошибок
        if (!httpServletRequest.getMethod().equalsIgnoreCase("GET") && !httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            out.println("<h2>Use GET or POST method.</h2>");
            System.out.println(ConsoleColors.RED + "[CCC] service: Method should be GET or POST\n");
            return;
        }
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
            // Создать новый объект cBean с новыми значениями value1, value2, value3
            cBean = new CBean(value1, value2, value3);
            // Установить атрибут запроса atrCBean
            if (attributeType.equalsIgnoreCase("request"))
                req.setAttribute("atrCBean", cBean);
            // Установить атрибут сессии atrCBean
            if (attributeType.equalsIgnoreCase("session"))
                session.setAttribute(sessionId, cBean);
            System.out.println(ConsoleColors.CYAN  +  "[CCC] service: Object:\t\t" + cBean);
            System.out.println(ConsoleColors.BLUE + "[CCC] service: atrCBean:\t" +
                    req.getAttribute("atrCBean") + ConsoleColors.YELLOW + " (new)\n");
        }
        else if (cBeanParameter.equalsIgnoreCase("old")) {
            System.out.println(ConsoleColors.CYAN  +  "[CCC] service: Object:\t\t" + cBean);
            System.out.println(ConsoleColors.BLUE + "[CCC] service: atrCBean:\t" +
                    req.getAttribute("atrCBean") + ConsoleColors.YELLOW + " (old)\n");
        }

        req.setAttribute("attributeType", attributeType);
        req.setAttribute("cBeanParameter", cBeanParameter);
        req.getRequestDispatcher("ccc.jsp").forward(req, res);
    }
}
