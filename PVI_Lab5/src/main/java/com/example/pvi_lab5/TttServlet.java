package com.example.pvi_lab5;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "tttServlet", value = "/ttt-servlet")
public class TttServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("ttt");
    }
}