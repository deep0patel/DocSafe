package Docsafe.userService.service.impl;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
public class EmailServiceImplS {

        @Autowired
        private JavaMailSender mailSender;

        public void sendHtmlEmail(String userID, String subject, String to, String from, org.slf4j.Logger logger) throws MessagingException {
            MimeMessage message = mailSender.createMimeMessage();

            String host="smtp.gmail.com";

            Properties properties = System.getProperties();
            System.out.println("PROPERTIES "+properties);

            //setting from address
            message.setFrom(new InternetAddress(from));

            //setting to address
            message.setRecipients(MimeMessage.RecipientType.TO, to);

            //setting the subject
            message.setSubject(subject);

            //setting the html part
            //going to make use of userID
            String htmlContent = "<h2>Thank you for joining DocSafe. Let's make document sharing easy and more secure</h2>"+"<h3>Please upload document by clicking link below.</h3>" +
                    "<p><a href=\" \" >Click here</a></p>";
            message.setContent(htmlContent, "text/html; charset=utf-8");

            mailSender.send(message);
        }

}
