package org.baeldung.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {
    private static final Logger logger = LogManager.getRootLogger();


    @Autowired
    JavaMailSender javaMailSender;


    public void sendMail() {

        logger.info("EmailService .. sendMail....");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Email Testing ...");
        message.setText("Body of Text ...");
        message.setTo("some_one@freddicmac.com");

        javaMailSender.send(message);

    }
}
