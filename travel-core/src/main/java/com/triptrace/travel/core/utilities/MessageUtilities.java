package com.triptrace.travel.core.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtilities {
    @Autowired
    MessageSource messageSource;

    public String get(String messageId){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(messageId,null,locale);
    }

    public String get(String messageId, Object ...args){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(messageId,args,locale);
    }
}
