package org.baeldung.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;

import java.util.Properties;

@Configuration
@PropertySource("classpath:mail.properties")
@ComponentScan(
        basePackages = "org.baeldung.services",
        excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootContextConfiguraiton {
    private static final Logger logger = LogManager.getRootLogger();

    @Autowired
    Environment env;

    @Bean
    JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setPort(2525);
        mailSender.setUsername(env.getProperty("mail.username"));
        mailSender.setPassword(env.getProperty("mail.password"));

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", env.getProperty("mail.properties.mail.smtp.starttls.enable"));
        javaMailProperties.put("mail.smtp.auth", env.getProperty("mail.properties.mail.smtp.auth"));
        javaMailProperties.put("mail.transport.protocol", env.getProperty("mail.properties.mail.transport.protocol"));
        javaMailProperties.put("mail.debug", env.getProperty("mail.properties.mail.debug"));

        mailSender.setJavaMailProperties(javaMailProperties);

        return mailSender;
    }
}
