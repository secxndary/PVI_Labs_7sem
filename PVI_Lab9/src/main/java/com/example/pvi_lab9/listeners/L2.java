package com.example.pvi_lab9.listeners;

import com.example.pvi_lab9.utils.ConsoleColors;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class L2 implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println(ConsoleColors.YELLOW + "[L2]  attributeAdded:\t\t" + attributeName + " = " + attributeValue);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println(ConsoleColors.YELLOW + "[L2] attributeRemoved: " + attributeName + " = " + attributeValue);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        Object oldValue = event.getValue();
        Object newValue = event.getSession().getAttribute(attributeName);
        System.out.println(ConsoleColors.YELLOW + "[L2]  attributeReplaced:\t" + attributeName +
                ", Old value: " + oldValue + ", New value: " + newValue);
    }
}