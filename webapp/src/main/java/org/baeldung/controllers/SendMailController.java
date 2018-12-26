package org.baeldung.controllers;

import org.baeldung.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SendMailController {
    private static final Logger logger = LogManager.getRootLogger();

    @Autowired
    EmailService emailService;

    @RequestMapping("/sendMail.htm")
    public ModelAndView sendMail() {
        logger.info("SendMailController ..sendMail...");

        emailService.sendMail();

        return new ModelAndView("welcome", "message", "Merry Christmas");
    }

}
