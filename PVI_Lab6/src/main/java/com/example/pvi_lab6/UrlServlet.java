package com.example.pvi_lab6;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "urlServlet", value = "/url-servlet")
public class UrlServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletContext servletContext = getServletContext();

        // Query-параметр urln (должен быть равен 1 или 2)
        String urlnParameter = request.getParameter("urln");
        System.out.println(ConsoleColors.PURPLE + "\nUrln parameter:\t\t" + ConsoleColors.YELLOW + urlnParameter);

        // Значение параметра инициализации сервлета (в web.xml) с param-name URL1 либо URL2
        String servletContextParameter = servletContext.getInitParameter("URL" + urlnParameter);
        System.out.println(ConsoleColors.PURPLE + "Context parameter:\t" + ConsoleColors.YELLOW + servletContextParameter);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (servletContextParameter == null)
            out.println("Parameter URLn not found.");
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(servletContextParameter);
        client.executeMethod(method);
        out.println(method.getResponseBodyAsString());
    }
}
