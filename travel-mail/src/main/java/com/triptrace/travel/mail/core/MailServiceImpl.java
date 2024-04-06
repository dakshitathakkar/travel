package com.triptrace.travel.mail.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
@Async
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendSimpleEmail(String[] to, String from, String subject, String messageBody) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(messageBody);
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sendHTMLEmail(String[] to, String from, String subject, String messageBody) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(to);
            messageHelper.setFrom(from);
            messageHelper.setSubject(subject);
            messageHelper.setText(messageBody,true);
        };
        javaMailSender.send(messagePreparator);
    }
}
