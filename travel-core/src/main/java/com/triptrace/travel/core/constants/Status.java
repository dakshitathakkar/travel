package com.triptrace.travel.core.constants;

public enum Status {
    SUBSCRIBED("SUBSCRIBED"),
    UNSUBSCRIBED("UNSUBSCRIBED");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String value(){
        return this.status;
    }
}
