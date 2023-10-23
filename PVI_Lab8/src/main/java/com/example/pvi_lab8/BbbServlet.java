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

        sb.append("<b>Headers: </b> <br />");
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            if (headerName.startsWith("x-"))
                sb.append(headerName).append(": ").append(req.getHeader(headerName)).append("<br />");
        }

        sb.append("<br /> <b>Params: </b> <br />");
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            sb.append(paramName).append(": ").append(req.getParameter(paramName)).append("<br />");
        }

        PrintWriter pw = res.getWriter();
        pw.println(sb);
    }
}