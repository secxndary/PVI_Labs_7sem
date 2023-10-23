package com.example.pvi_lab8;
import java.io.*;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "bbbServlet", value = "/bbb-servlet")
public class BbbServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Enumeration<String> headers = req.getHeaderNames();
        Enumeration<String> params = req.getParameterNames();
        StringBuilder sb = new StringBuilder();

        sb.append("<b>Request headers: </b> <br />");
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            if (headerName.startsWith("x-"))
                sb.append(headerName).append(": ").append(req.getHeader(headerName)).append("<br />");
        }

        sb.append("<br /> <b>Request params: </b> <br />");
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            sb.append(paramName).append(": ").append(req.getParameter(paramName)).append("<br />");
        }

        res.addHeader("x-header-bbb-1", "1st custom header from Bbb servlet");
        res.addHeader("x-header-bbb-2", "2nd custom header from Bbb servlet");

        res.getWriter().println(sb);
    }
}