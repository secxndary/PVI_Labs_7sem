package com.example.pvi_lab13;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "files", value = "/files")
public class SssServlet extends HttpServlet {
    BufferedWriter writer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String fileName = req.getParameter("file");
        String directoryPath = getServletContext().getInitParameter("filesPath");

        if (fileName == null) {
            Find files = new Find(directoryPath, "docx");
            res.setContentType("text/html; charset=utf-8");

            StringBuilder sb = new StringBuilder();
            sb.append("<h1>Files</h1>");
            for (String file : files.list)
                sb.append("<a href='/PVI_Lab13_war_exploded/files?file=").append(file).append("' >").append(file).append("</a>").append("<br>");
            res.getWriter().println(sb);
        }
        else {
            System.out.println(fileName);
            try {
                writeFile(fileName);
                File document = new File(directoryPath.concat("\\").concat(fileName));
                res.setContentType("application/msword; charset=utf-8");
                res.addHeader("Content-Disposition", "attachment; fileName=" + document.getName());
                res.setContentLength((int)document.length());

                FileInputStream in = new FileInputStream(document);
                BufferedInputStream buf = new BufferedInputStream(in);
                ServletOutputStream out = res.getOutputStream();
                int readBytes;
                while ((readBytes = buf.read()) != -1) {
                    out.write(readBytes);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void writeFile(String fileName) throws IOException {
        writer = new BufferedWriter(new FileWriter("C:\\Users\\valda\\source\\repos\\semester#7\\PvI\\PVI_Lab13\\output.txt", true));
        writer.append(fileName);
        writer.append("\n");
        writer.close();
    }
}