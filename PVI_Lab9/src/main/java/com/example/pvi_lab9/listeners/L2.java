package com.example.pvi_lab9.listeners;

import com.example.pvi_lab9.utils.ConsoleColors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class L2 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(ConsoleColors.GREEN + "[L2] Context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(ConsoleColors.YELLOW + "[L2] Context destroyed");
    }
}