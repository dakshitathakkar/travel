package com.triptrace.travel.core.constants;

public class ApplicationConstant {

    //Prompts
    public static final String HOME_API_PROMPT = "Top 5 Travel Destination cities with their states with one liner description for month = %s,country = %s. Do not use anything like double asterisk to enclose names";
    public static final String TRAVEL_ITINERARY_PROMPT = "Give me a travel itinerary with the following filter: Month: %s, " +
            "Continent: %s, Country: %s, Weather: %s, Days: %s, Budget: %s " +
            "Travelling with: %s, Resident of:%s";

    //regex
    public static final String CHATBOT_OUTPUT_REGEX = "(\\w+),\\s*(.*)(?:\\s*-\\s*|\\s*:)\\s*(.*)$";
    public static final String NEXT_LINE_DELIMITER = "\\n";

    //Email
    public static final String MAIL_SENDER_EMAIL = "spring.mail.email";
}
