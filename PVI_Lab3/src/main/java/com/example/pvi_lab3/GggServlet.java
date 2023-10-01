package com.example.pvi_lab3;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "gggServlet", value = "/ggg-servlet")
public class GggServlet extends HttpServlet {

    public void init() {
        System.out.println(ConsoleColors.GREEN + "[GGG] init()");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(ConsoleColors.PURPLE + "[GGG] doGet\n");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println(ConsoleColors.BLUE + "[GGG] service\n");

        String requestType = req.getMethod();

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>Service: GGG</h1>");
        out.println("<h3>Request type: " + requestType + "</h3>");
        out.println("</body></html>");
    }

    public void destroy() {
        System.out.println(ConsoleColors.YELLOW + "[GGG] destroy");
    }
}