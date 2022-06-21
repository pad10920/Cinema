package com.example.cinema.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {
    public static void sendEmail(String diaChiNguoiNhan, String chude, String noidung){

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("cinemaltweb@gmail.com", "anlkdhnfxdsbgoxy");
            }
        };

        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        try {
            Address nguoiGui = new InternetAddress("cinemaltweb@gmail.com", "Meta Cinema");
            msg.setFrom(nguoiGui);
            InternetAddress[] toAddresses = { new InternetAddress(diaChiNguoiNhan) };
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject(chude);
            msg.setSentDate(new Date());
            msg.setContent(noidung, "text/html; charset=utf-8");
            // sends the e-mail
            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
