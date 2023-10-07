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
        String urlnParameter = request.getParameter("urln");
        ServletContext servletContext = getServletContext();
        String uri = servletContext.getInitParameter("URL" + urlnParameter);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (uri != null) {
            HttpClient client = new HttpClient();
            GetMethod method = new GetMethod(uri);
            client.executeMethod(method);
            out.println(method.getResponseBodyAsString());
        } else {
            out.println("Parameter URLn not found.");
        }
    }
}
