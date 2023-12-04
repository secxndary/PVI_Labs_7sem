package com.example.pvi_lab13;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sssServlet", value = "/sss-servlet")
public class SssServlet extends HttpServlet {
    BufferedWriter writer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filename = req.getParameter("file");
        String docdir = getServletContext().getInitParameter("files");

        if (filename == null) {
            Find files = new Find(docdir, "docx");
            resp.setContentType("text/html");

            StringBuilder result = new StringBuilder();
            for (String file : files.list) {
                result.append("<br>").append("<a href='/PVI_Lab13_war_exploded/files?file=").append(file).append("' >").append(file).append("</a>");
            }
            resp.getWriter().println(result);
        }
        else {
            System.out.println(filename);
            try {
                //пересылка word клиенту
                lofFile(filename);
                File doc = new File(docdir.concat("\\").concat(filename));
                resp.setContentType("application/msword");
                resp.addHeader("Content-Disposition", "attachment; filename="+ doc.getName());
                resp.setContentLength((int) doc.length());

                FileInputStream in = new FileInputStream(doc);
                BufferedInputStream buf = new BufferedInputStream(in);
                ServletOutputStream out = resp.getOutputStream();
                int readBytes = 0;
                while ((readBytes = buf.read()) != -1) {
                    out.write(readBytes);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void lofFile(String fileName) throws IOException {
        System.out.println("log");
        writer = new BufferedWriter(new FileWriter("C:\\Users\\valda\\source\\repos\\semester#7\\PvI\\PVI_Lab13\\output.txt", true));
        writer.append(fileName);
        writer.append("\n");
        writer.close();
    }
}