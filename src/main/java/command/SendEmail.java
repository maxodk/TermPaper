package command;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendEmail {
    public void send() {
        final String username = "maxim.milinevskiy@outlook.com";
        final String password = "Gta6pl73";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("maxim.milinevskiy@outlook.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("maxim.milinevskiy@outlook.com")
            );
            message.setSubject("Запит на пошту");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Вітаю , надсилаю Вам приклад лог файлу");
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File("D:\\Java\\Lab7\\src\\main\\resources\\Results.txt"));
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



