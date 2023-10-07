package com.example.customtags;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class LastnameTag extends TagSupport {
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("<input type=\"text\" name=\"lastname\">");
        }
        catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}