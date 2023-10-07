package com.example.pvi_lab4;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "jjjServlet", value = "/jjj-servlet")
public class JjjServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String jspName = request.getParameter("jspName");
        String redirectType = request.getParameter("redirectType");

        switch (redirectType) {
            case "forward":
                RequestDispatcher dispatcher = request.getRequestDispatcher(jspName);
                dispatcher.forward(request, response);
                break;
            case "redirect":
                response.sendRedirect(jspName);
                break;
            case "httpClient":
                HttpClient clientPost = new HttpClient();
                PostMethod methodPost = new PostMethod("http://localhost:8081/PVI_Lab4_war_exploded/" + jspName);
                clientPost.executeMethod(methodPost);
                response.setContentType("text/html");
                PrintWriter pwPost = response.getWriter();
                pwPost.println(methodPost.getResponseBodyAsString());
                pwPost.flush();
                break;
            default:
                throw new ServletException("Unable to redirect/dispatch. Please, check hidden inputs values in index.jsp");
        }
    }
}