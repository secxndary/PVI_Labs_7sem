package com.example.pvi_lab15;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "SendEmail", urlPatterns = "/SendEmail")
public class SendEmail extends HttpServlet
{
    String senderEmail;
    String senderEmailPassword;
    String senderHostProtocol;
    String senderPort;
    String receiverEmailAddress;
    String subjectText;
    String messageText;

    public void init(ServletConfig sc)
    {
        senderEmail =  sc.getServletContext().getInitParameter("sender_email");
        senderEmailPassword = sc.getServletContext().getInitParameter("sender_email_password");
        senderHostProtocol = sc.getServletContext().getInitParameter("host_protocol");
        senderPort = sc.getServletContext().getInitParameter("port");
        receiverEmailAddress = sc.getServletContext().getInitParameter("receiver_email");
        subjectText = sc.getServletContext().getInitParameter("subject_text");
        messageText = sc.getServletContext().getInitParameter("message_text");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", senderHostProtocol);
        properties.put("mail.smtp.port", senderPort);
        properties.put("mail.from", senderEmail);
        properties.put("mail.smtp.password", senderEmailPassword);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new jakarta.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    { return new PasswordAuthentication(senderEmail, senderEmailPassword); }
                });

        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailAddress));
            message.setSubject(subjectText);
            message.setText(messageText);
            Transport.send(message);
            response.getWriter().println("<h1>Email successfully sent<h1>");
        }
        catch (MessagingException e)
        {
            response.getWriter().println(e.getMessage());
        }
    }
}
