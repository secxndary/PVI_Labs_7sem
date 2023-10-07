package com.example.customtags;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class SexTag extends TagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("<input type=\"radio\" name=\"sex\" value=\"" + value + "\"> " + value);
        }
        catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }
}