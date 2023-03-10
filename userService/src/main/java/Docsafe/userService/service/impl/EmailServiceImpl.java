package Docsafe.userService.service.impl;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl {

    public boolean sendEmail(String message, String subject, String to, String from, org.slf4j.Logger logger) {

        boolean value = false;
        //Variable for gmail
        String host="smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step 1: to get the session object...
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("deep1234p@gmail.com", "DEEP@2110");
            }



        });

        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);

        try {



            //adding recipient to message
            m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //from email
            m.setFrom(new InternetAddress(from));

            //adding subject to message
            m.setSubject(subject);


            //adding text to message
            m.setText(message);

            //send

            //Step 3 : send the message using Transport class
            Transport.send(m);

            System.out.println("Sent success...................");
            value = true;


        }catch (Exception e) {
            e.printStackTrace();
        }

        return value;

    }

}
