package com.example.pvi_lab9.filters;

import com.example.pvi_lab9.utils.ConsoleColors;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class F1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println(ConsoleColors.GREEN + "[F1] init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {

        if (req.getParameter("value2") != null && req.getParameter("value1").isEmpty()) {
            res.setContentType("text/html");
            res.getWriter().println("<h1>[F1] Enter the value1 to pass the filter chain.</h1>");
            System.out.println(ConsoleColors.RED + "\n[F1] doFilter: Filter stopped here.");
            return;
        }

        System.out.println(ConsoleColors.GREEN + "\n[F1] doFilter: Filter passed.");
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        System.out.println(ConsoleColors.YELLOW + "[F1] destroy");
    }
}