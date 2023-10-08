package com.example.pvi_lab6;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cccServlet", value = "/ccc-servlet")
public class CccServlet extends HttpServlet {

    @Override
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(ConsoleColors.BLUE + "[CCC] doGet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(ConsoleColors.CYAN + "[CCC] doPost");
    }
}
