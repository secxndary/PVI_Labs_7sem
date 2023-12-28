<%@ page import="by.bstu.service.WSRefService" %>
<%@ page import="by.bstu.entity.WSRef" %>
<%@ page import="by.bstu.service.WSRefCommentService" %>
<%@ page import="by.bstu.entity.WSRefComment" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<header>
    <script src="js/main.js"></script>
    <script src="js/forms.js"></script>
</header>
<title>UWSR</title>
<body>
<%
    String role;
    if (request.getSession().getAttribute("role") == null) {
        role = "quest";
    } else {
        role = request.getSession().getAttribute("role").toString();
    }
    if (role.equals("admin")) {
%>
<div>
    <input type="text" id="url" placeholder="url">
    <input type="text" id="description" placeholder="key-word, key-word">
    <button onclick="add()">Add</button>
</div>
<%
    }
%>
<br>
<button name="filterKey" onclick="filterKey()">Filter</button>
<br><br>
<form id="filterForm" action="./URL?action=filter" method="post" style="display: none;">
    <input type="text" name="key">
    <input type="submit" value="submit">
    <input type="reset" value="cancel">
</form>
<br>
<%
    String key = "";
    if (request.getSession().getAttribute("key") != null) {
        key = request.getSession().getAttribute("key").toString();
    }
    if (role.equals("admin")) {
        WSRefService service = new WSRefService();
        for (WSRef wsRef :
                service.findAllByKey(key)) {
            String updUrl = wsRef.getUrl();
            String updDescription = wsRef.getDescription();
            String urlUpdAction = "./URL?action=upd&id=" + wsRef.getId();
            String urlCommentAddAction = "./URL?action=addComment&id=" + wsRef.getId();
%>
<div>
    <button onclick="updateForm(<%=wsRef.getId()%>)">Update</button>
    <button onclick="del(<%=wsRef.getId()%>)">Delete</button>
    <button onclick="addLike(<%=wsRef.getId()%>)">+<%=wsRef.getPlus()%>
    </button>
    <button onclick="addDisLike(<%=wsRef.getId()%>)">-<%=wsRef.getMinus()%>
    </button>
    <button onclick="commentForm(<%=wsRef.getId()%>)">Comments</button>
    <a href="<%=wsRef.getUrl()%>"><%=wsRef.getDescription()%>
    </a>
    <br>
    <form id="updForm<%=wsRef.getId()%>" action="<%=urlUpdAction%>" onsubmit="submitUpdForm(event, <%=wsRef.getId()%>)"
          method="post"
          style="display: none;">
        <input type="text" name="updURL" value="<%=updUrl%>">
        <input type="text" name="updDescription" value="<%=updDescription%>">
        <input type="submit" value="submit">
    </form>
    <br>
    <div id="commentForm<%=wsRef.getId()%>" style="display: none;">
        <form id="commentAddForm<%=wsRef.getId()%>" action="<%=urlCommentAddAction%>"
              onsubmit="commentAdd(event, <%=wsRef.getId()%>)" method="post">
            <input type="text" name="comtextForm">
            <input type="submit" value="submit">
        </form>
        <%
            WSRefCommentService wsRefCommentService = new WSRefCommentService();
            for (WSRefComment wsRefComment :
                    wsRefCommentService.findAllByWsRefId(wsRef.getId())) {
                String comtext = wsRefComment.getComtext();
                Date stamp = wsRefComment.getStamp();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sdf.format(stamp);
        %>
        <label type="text" name="stamp"><%=formattedDate%>
        </label><br>
        <textarea type="text" id="comtext<%=wsRefComment.getId()%>" name="comtext"
                  rows="3"><%=comtext%></textarea>
        <br>
        <button onclick="updComment(<%=wsRefComment.getId()%>)">Update</button>
        <button onclick="delComment(<%=wsRefComment.getId()%>)">Delete</button>
        <br>
        <br>
        <%
            }
        %>
    </div>
</div>
<%
    }
} else {
    WSRefService service = new WSRefService();
    for (WSRef wsRef :
            service.findAllByKey(key)) {
        String urlCommentAddAction = "./URL?action=addComment&id=" + wsRef.getId();
%>
<div>
    <button onclick="addLike(<%=wsRef.getId()%>)">+<%=wsRef.getPlus()%>
    </button>
    <button onclick="addDisLike(<%=wsRef.getId()%>)">-<%=wsRef.getMinus()%>
    </button>
    <button onclick="commentForm(<%=wsRef.getId()%>)">Comments</button>
    <a href="<%=wsRef.getUrl()%>"><%=wsRef.getDescription()%>
    </a>
    <div id="commentForm<%=wsRef.getId()%>" style="display: none;">
        <form id="commentAddForm<%=wsRef.getId()%>" action="<%=urlCommentAddAction%>"
              onsubmit="commentAdd(event, <%=wsRef.getId()%>)" method="post">
            <input type="text" name="comtextForm">
            <input type="submit" value="submit">
        </form>
        <%
            WSRefCommentService wsRefCommentService = new WSRefCommentService();
            for (WSRefComment wsRefComment :
                    wsRefCommentService.findAllByWsRefId(wsRef.getId())) {
                String comtext = wsRefComment.getComtext();
                Date stamp = wsRefComment.getStamp();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sdf.format(stamp);
        %>
        <label type="text" name="stamp"><%=formattedDate%>
        </label><br>
        <textarea type="text" id="comtext<%=wsRefComment.getId()%>" name="comtext"
                  rows="3"><%=comtext%></textarea>
        <br>
        <%
            if (wsRefComment.getSessionId().equals(request.getSession().getId())) {
        %>
        <button onclick="updComment(<%=wsRefComment.getId()%>)">Update</button>
        <button onclick="delComment(<%=wsRefComment.getId()%>)">Delete</button>
        <br>
        <br>
        <%
                }
            }
        %>
    </div>
</div>
<%
        }
    }
%>
</body>
</html>