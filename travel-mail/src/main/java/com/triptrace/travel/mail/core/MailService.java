package com.triptrace.travel.mail.core;

public interface MailService {

    void sendSimpleEmail(String[] to, String from, String subject, String messageBody);

    void sendHTMLEmail(String[] to, String from, String subject, String messageBody);
}
