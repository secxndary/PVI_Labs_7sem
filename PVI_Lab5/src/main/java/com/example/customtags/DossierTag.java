package com.example.customtags;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class DossierTag extends TagSupport {
    private String action;

    public void setAction(String action) {
        this.action = action;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("<form action=\"" + action + "\" method=\"POST\">");
        }
        catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("</form>");
        }
        catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }
}