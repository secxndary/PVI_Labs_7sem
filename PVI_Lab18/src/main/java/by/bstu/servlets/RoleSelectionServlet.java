package by.bstu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UWSR")
public class RoleSelectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("r");
        if (role != null && role.equals("admin")) {
            req.getSession().setAttribute("role", "admin");
            req.getSession().setAttribute("key", "");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("role", "quest");
            req.getSession().setAttribute("key", "");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
