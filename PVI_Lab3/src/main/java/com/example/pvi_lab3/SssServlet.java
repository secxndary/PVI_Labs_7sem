package com.example.pvi_lab3;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sssServlet", value = "/sss-servlet")
public class SssServlet extends HttpServlet {

    public void init() {
        System.out.println(ConsoleColors.GREEN + "[SSS] init()");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(ConsoleColors.PURPLE + "[SSS] doGet\n");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
        System.out.println(ConsoleColors.CYAN + "[SSS] service");

        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        HttpServletResponse httpServletResponse = (HttpServletResponse)res;

        String requestType = httpServletRequest.getMethod();
        String redirectType = req.getParameter("redirectType");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h1>Service: SSS</h1>");
        out.println("<h3>Request type: " + requestType + "</h3>");
        out.println("</body></html>");

        System.out.println(ConsoleColors.PURPLE + "[SSS] " + redirectType + "\n");

        switch (redirectType) {
            case "gggDispatcher":
                // Переопределение на GggServlet
                RequestDispatcher dispatcherGgg = req.getRequestDispatcher("ggg-servlet");
                dispatcherGgg.forward(req, res);
                break;
            case "htmlDispatcher":
                // Переопределение на dispatcher.html
                RequestDispatcher dispatcherHtml = req.getRequestDispatcher("dispatcher.html");
                dispatcherHtml.forward(req, res);
                break;
            case "tripleDispatcher":
                // Переопределение Sss -> Ggg -> html
                RequestDispatcher dispatcherTriple = req.getRequestDispatcher("ggg-servlet");
                dispatcherTriple.forward(req, res);
                int stub;
                break;

            case "gggRedirect":
                // Переадресация на GggServlet
                httpServletResponse.sendRedirect("ggg-servlet");
                break;
            case "htmlRedirect":
                // Переадресация на html
                httpServletResponse.sendRedirect("dispatcher.html");
                break;
            case "tripleRedirect":
                // Переадресация Sss -> Ggg -> html
                httpServletRequest.getSession().setAttribute("redirectType", redirectType);
                httpServletResponse.sendRedirect("ggg-servlet");
                break;

            case "httpClientLocal":
                // Запрос к Ggg (local)
                HttpClient client = new HttpClient();
                GetMethod method = new GetMethod("http://localhost:8081/PVI_Lab3_war_exploded/ggg-servlet?firstname=alexander&lastname=valdaitsev");
                client.executeMethod(method);
                res.setContentType("text/html");
                PrintWriter pw = res.getWriter();
                pw.println(method.getResponseBodyAsString());
                pw.flush();
                break;
            case "httpClientRemote":
                // Запрос к Ggg (remote)
                HttpClient clientRemote = new HttpClient();
                GetMethod methodRemote = new GetMethod("http://remote-server-7:8080/PVI_Lab3-1.0-SNAPSHOT/ggg-servlet?firstname=alexander&lastname=valdaitsev");
                clientRemote.executeMethod(methodRemote);
                res.setContentType("text/html");
                PrintWriter pwRemote = res.getWriter();
                pwRemote.println(methodRemote.getResponseBodyAsString());
                pwRemote.flush();
                break;
            case "httpClientLocalPost":
                // Запрос к Ggg (local)
                HttpClient clientPost = new HttpClient();
                PostMethod methodPost = new PostMethod("http://localhost:8081/PVI_Lab3_war_exploded/ggg-servlet?firstname=alexander&lastname=valdaitsev");
                clientPost.executeMethod(methodPost);
                res.setContentType("text/html");
                PrintWriter pwPost = res.getWriter();
                pwPost.println(methodPost.getResponseBodyAsString());
                pwPost.flush();
                break;
            default:
                throw new ServletException("Unable to redirect/dispatch. Please, check hidden inputs values in index.jsp");
        }
    }

    public void destroy() {
        System.out.println(ConsoleColors.YELLOW + "[SSS] destroy");
    }
}