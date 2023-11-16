package com.example.pvi_lab9.filters;

import com.example.pvi_lab9.utils.ConsoleColors;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class F2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println(ConsoleColors.GREEN + "[F2] init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        String[] uriSplitArray = httpServletRequest.getRequestURI().split("/");
        String URN = uriSplitArray[uriSplitArray.length - 1];

        // Если обращаемся напрямую к ccc.jsp, То запрещаем доступ
        if (URN.equalsIgnoreCase("ccc.jsp")) {
            out.println("<h1>[F2] You cannot access ccc.jsp via URI.</h1>");
            System.out.println(ConsoleColors.RED + "[F2] doFilter: Filter stopped here (caused by URI).");
            return;
        }

        // Общий случай для фильтрации сервлета (аналогично F1 и F3)
        if (req.getParameter("value2") != null && req.getParameter("value2").isEmpty()) {
            out.println("<h1>[F2] Enter the value2 to pass the filter chain.</h1>");
            System.out.println(ConsoleColors.RED + "[F2] doFilter: Filter stopped here.");
            return;
        }

        System.out.println(ConsoleColors.GREEN + "[F3] doFilter: Filter passed.");
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        System.out.println(ConsoleColors.YELLOW + "[F2] destroy");
    }
}