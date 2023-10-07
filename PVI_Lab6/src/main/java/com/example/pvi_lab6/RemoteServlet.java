package com.example.pvi_lab6;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "remoteServlet", value = "/remote-servlet")
public class RemoteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Remote Servlet</h1>");
        out.println("</body></html>");
    }
}