package com.example.pvi_lab8;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "aaaServlet", value = "/aaa-servlet")
public class AaaServlet extends HttpServlet {

    public void service(ServletRequest req, ServletResponse res) throws IOException {
        String uriLocal = "http://localhost:8081/PVI_Lab8_war_exploded/bbb-servlet";
        String uriRemote = "http://remote-server-7:8080/PVI_Lab8-1.0-SNAPSHOT/bbb-servlet";
        HttpClient client = new HttpClient();
        PostMethod methodPost = new PostMethod(uriRemote);

        String name1 = req.getParameter("name1");
        String name2 = req.getParameter("name2");
        String name3 = req.getParameter("name3");
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        String value3 = req.getParameter("value3");

        methodPost.addRequestHeader(name1, value1);
        methodPost.addRequestHeader(name2, value2);
        methodPost.addRequestHeader(name3, value3);
        methodPost.addParameter(name1, value1);
        methodPost.addParameter(name2, value2);
        methodPost.addParameter(name3, value3);

        client.executeMethod(methodPost);

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        pw.println("<h1>Bbb response body: </h1>");
        pw.println(methodPost.getResponseBodyAsString());
        pw.println("<br /> <h1>Bbb response headers:</h1>");

        Header[] headers = methodPost.getResponseHeaders();
        for (Header header : headers)
            pw.println(header.getName() + ": " + header.getValue() + "<br />");
        pw.flush();
    }
}