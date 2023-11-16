package com.example.pvi_lab9.filters;

import com.example.pvi_lab9.utils.ConsoleColors;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class F3 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println(ConsoleColors.GREEN + "[F3] init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {

        if (req.getParameter("value2") != null && req.getParameter("value3").isEmpty()) {
            res.setContentType("text/html");
            res.getWriter().println("<h1>[F3] Enter the value3 to pass the filter chain.</h1>");
            System.out.println(ConsoleColors.RED + "[F3] doFilter: Filter stopped here.");
            return;
        }

        System.out.println(ConsoleColors.GREEN + "[F3] doFilter: Filter passed.");
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        System.out.println(ConsoleColors.YELLOW + "[F3] destroy");
    }
}