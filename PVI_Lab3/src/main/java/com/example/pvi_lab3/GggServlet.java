package com.example.pvi_lab3;
import javax.servlet.RequestDispatcher;
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
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println(ConsoleColors.BLUE + "[GGG] service");

        String requestType = req.getMethod();

        String redirectTypeFromQuery = req.getParameter("redirectType");
        String redirectTypeFromSession = (String) req.getSession().getAttribute("redirectType");

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>Service: GGG</h1>");
        out.println("<h3>Request type: " + requestType + "</h3>");
        // При запросе с Sss на Ggg c помощью org.apache.commons.httpclient
        if (firstName != null && lastName != null) {
            out.println("<h2>Firstname: "  + firstName + "</h2>");
            out.println("<h2>Lastname: "  + lastName + "</h2>");
        }
        out.println("</body></html>");

        System.out.println(ConsoleColors.PURPLE + "[GGG] query:    " + redirectTypeFromQuery);
        System.out.println(ConsoleColors.PURPLE + "[GGG] session:  " + redirectTypeFromSession + "\n");

        // Переопределение Sss -> Ggg -> html
        if (redirectTypeFromQuery != null && redirectTypeFromQuery.equalsIgnoreCase("tripleDispatcher")) {
            RequestDispatcher dispatcherTriple = req.getRequestDispatcher("dispatcher.html");
            dispatcherTriple.forward(req, res);
        }
        // Переадресация Sss -> Ggg -> html
        if (redirectTypeFromSession.equalsIgnoreCase("tripleRedirect")) {
            res.sendRedirect("dispatcher.html");
        }
    }

    public void destroy() {
        System.out.println(ConsoleColors.YELLOW + "[GGG] destroy");
    }
}