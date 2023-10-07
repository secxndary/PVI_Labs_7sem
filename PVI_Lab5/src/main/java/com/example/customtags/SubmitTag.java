package com.example.customtags;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class SubmitTag extends TagSupport {

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("<input type=\"submit\" name=\"ok\" value=\"OK\">");
            out.println("<input type=\"submit\" name=\"cancel\" value=\"Cancel\">");
        }
        catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}