package com.triptrace.travel.mail.core.newsletter;

import com.triptrace.travel.core.constants.ApplicationConstant;
import com.triptrace.travel.core.constants.MailType;
import com.triptrace.travel.core.constants.MessageConstant;
import com.triptrace.travel.core.utilities.MessageUtilities;
import com.triptrace.travel.mail.core.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class NewsletterMail {
    private final MailService mailService;
    private final Environment env;
    private final MessageUtilities message;

    private String[] to;
    private String from;
    private String subject;
    private String messageBody;

    @Autowired
    public NewsletterMail(MailService mailService, Environment env, MessageUtilities message) {
        this.mailService = mailService;
        this.env = env;
        this.message = message;
    }

    private void formMessageParams(){
        from = env.getProperty(ApplicationConstant.MAIL_SENDER_EMAIL);
        to = new String[]{"dakshitathakkar14@gmail.com"};
    }

    public void sendEmailNotification(MailType mailType){
        try {
            formMessageParams();
            switch (mailType){
                case WELCOME_EMAIL:
                    subject = message.get(MessageConstant.NEWSLETTER_WELCOME_MAIL_SUBJECT);
                    messageBody = message.get(MessageConstant.NEWSLETTER_WELCOME_MAIL_TEMPLATE);
                    break;
            }
            mailService.sendHTMLEmail(to,from,subject,messageBody);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
