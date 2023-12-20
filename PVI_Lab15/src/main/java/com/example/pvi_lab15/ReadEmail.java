package com.example.pvi_lab15;

import jakarta.mail.PasswordAuthentication;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import java.io.IOException;
import java.util.Properties;

public class ReadEmail
{
    public static String showMessages(final String userEmail, final String password) throws MessagingException
    {
        String host = "imap.googlemail.com";
        Properties properties = new Properties();
        properties.put("mail.imaps.ssl.trust", "*");
        Store store = Session.getInstance(properties, new jakarta.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(userEmail, password);
            }
        }).getStore("imaps");
        store.connect(host, userEmail, password);
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        StringBuilder sb = new StringBuilder();

        for (Message message: folder.getMessages(1, 200))
        {
            sb.append("<a href='/PVI_Lab15_war_exploded/getMessage.jsp?date=")
                    .append(message.getSentDate())
                    .append("'>")
                    .append(message.getSubject())
                    .append("</a><br>");
        }

        folder.close(true);
        store.close();
        return sb.toString();
    }

    public static String getMessage(final String userEmail, final String password, final String date) throws MessagingException, IOException, IOException
    {
        String host = "imap.googlemail.com";
        Properties properties = new Properties();
        properties.put("mail.imaps.ssl.trust", "*");
        Store store = Session.getInstance(properties, new jakarta.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(userEmail, password);
            }
        }).getStore("imaps");
        store.connect(host, userEmail, password);
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        StringBuilder sb = new StringBuilder();
        for (Message message: folder.getMessages())
        {
            if (message.getSentDate().toString().equals(date))
            {
                sb.append("<div  style='cursor: pointer;'>");
                sb.append("<p>Sender:   ").append(InternetAddress.toString(message.getFrom())).append("<br/>");
                sb.append("Theme:   ").append(message.getSubject()).append("<br/>");
                String messageContent = null;
                String contentType = message.getContentType();

                if (contentType.contains("multipart"))
                {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++)
                    {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        messageContent = part.getContent().toString();
                    }
                }
                else if (contentType.contains("text/plain") || contentType.contains("text/html"))
                {
                    Object content = message.getContent();
                    if (content != null)
                        messageContent = content.toString();
                }
                sb.append("Message: ").append(messageContent).append("<br/>");
                sb.append("Date:    ").append(message.getSentDate()).append("</p>");
                sb.append("</div>");
                sb.append("-----------------------------------------------");
                sb.append("</br>");
                break;
            }
        }

        folder.close(true);
        store.close();
        return sb.toString();
    }
}