package com.triptrace.travel.core.constants;

public class ApplicationConstant {
    public static final String HOME_API_PROMPT = "Top 5 Travel Destination cities with their states with one liner description for month = %s,country = %s. Do not use anything like double asterisk to enclose names";
    public static final String HOME_API_SAMPLE_OUTPUT_TEST = "1. Jaipur, Rajasthan - Explore the vibrant culture and majestic palaces of the Pink City during the pleasant weather of March" +
            ".\n2. Rishikesh, Uttarakhand - Embark on a spiritual journey and indulge in" +
            " adventure activities along the banks of the holy Ganges River.\n3. Munnar, Kerala " +
            "- Witness the blooming tea gardens and lush greenery of this picturesque hill station" +
            " in South India.\n4. Hampi, Karnataka - Discover the ancient ruins and rock-cut temples";

    public static final String CHATBOT_OUTPUT_REGEX = "(\\w+),\\s*(.*)(?:\\s*-\\s*|\\s*:)\\s*(.*)$";
    public static final String NEXT_LINE_DELIMITER = "\\n";

    //Email
    public static final String MAIL_SENDER_EMAIL = "spring.mail.email";
}
