package com.triptrace.travel.core.constants;

public enum MailType {
    WELCOME_EMAIL("WELCOME_EMAIL"),
    WEEKLY_EMAIL("WEEKLY_EMAIL");

    private String value;

    private MailType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
