package by.bstu.servlets;

import by.bstu.entity.WSRef;
import by.bstu.entity.WSRefComment;
import by.bstu.service.WSRefCommentService;
import by.bstu.service.WSRefService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/URL")
public class URLActionServlet extends HttpServlet {

    @Override
    public void init() {
        getServletContext().setAttribute("wsRefService", new WSRefService());
        getServletContext().setAttribute("wsRefCommentService", new WSRefCommentService());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action") != null) {
            WSRefService wsRefService = (WSRefService) getServletContext().getAttribute("wsRefService");
            WSRefCommentService wsRefCommentService = (WSRefCommentService) getServletContext().getAttribute("wsRefCommentService");
            String action = req.getParameter("action");
            switch (action) {
                case "add": {
                    WSRef wsRef = new WSRef();
                    wsRef.setUrl(req.getParameter("url"));
                    wsRef.setDescription(req.getParameter("description"));
                    wsRefService.save(wsRef);
                    break;
                }
                case "upd": {
                    WSRef wsRef = wsRefService.findById(Integer.parseInt(req.getParameter("id")));
                    wsRef.setUrl(req.getParameter("updURL"));
                    wsRef.setDescription(req.getParameter("updDescription"));
                    wsRefService.update(wsRef);
                    break;
                }
                case "del": {
                    wsRefService.delete(Integer.parseInt(req.getParameter("id")));
                    break;
                }
                case "addLike": {
                    wsRefService.addLike(Integer.parseInt(req.getParameter("id")));
                    break;
                }
                case "addDisLike": {
                    wsRefService.addDisLike(Integer.parseInt(req.getParameter("id")));
                    break;
                }
                case "addComment":{
                    WSRefComment wsRefComment = new WSRefComment();
                    System.out.println(req.getParameter("comtext"));
                    wsRefComment.setStamp(new Date());
                    wsRefComment.setComtext(req.getParameter("comtext"));
                    wsRefComment.setSessionId(req.getSession().getId());
                    wsRefComment.setWsref(wsRefService.findById(
                            Integer.parseInt(req.getParameter("id"))));
                    wsRefCommentService.save(wsRefComment);
                    break;
                }
                case "updComment":{
                    WSRefComment wsRefComment = wsRefCommentService.findById(
                            Integer.parseInt(req.getParameter("id")));
                    wsRefComment.setComtext(req.getParameter("comtext"));
                    wsRefComment.setStamp(new Date());
                    wsRefCommentService.update(wsRefComment);
                    break;
                }
                case "delComment":{
                    wsRefCommentService.delete(Integer.parseInt(req.getParameter("id")));
                    break;
                }
                case "filter":{
                    req.getSession().setAttribute("key", req.getParameter("key"));
                    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                    break;
                }
            }
        }
    }
}
