package org.baeldung.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.baeldung.config.RootContextConfiguraiton;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootContextConfiguraiton.class})
public class EmailServiceImplTest {
    private static final Logger logger = LogManager.getRootLogger();

    @Autowired
    EmailService emailService;

    @Test
    public void testSendMail() {
        logger.info("EmailServiceImplTest .. testSendMail...");
        emailService.sendMail();
    }
}