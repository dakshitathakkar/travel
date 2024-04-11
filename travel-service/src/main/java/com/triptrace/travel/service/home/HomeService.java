package com.triptrace.travel.service.home;

import com.triptrace.travel.core.constants.Month;
import com.triptrace.travel.dao.entities.Subscriber;
import com.triptrace.travel.dao.entities.TopTravelDestination;

import java.util.List;

public interface HomeService {

    /**
     * Get all travel destinations
     * @param month
     * @param country
     * @return
     */
    List<TopTravelDestination> getTopTravelDestinations(String month, String country);

    /**
     * Method to get destinations from database
     * @param month
     * @param country
     * @return
     */
    List<TopTravelDestination> getAllDestinationsByMonthAndCountry(Month month, String country);

    /**
     * Method to add email to subscriber list
     * @param subscriber
     */
    void subscribeEmailToNewsletter(Subscriber subscriber);

    /**
     * Method to update subscriber details
     * @param subscriberParams
     * @param currentSubscriber
     * @return
     */
    Subscriber updateSubsriber(Subscriber subscriberParams, Subscriber currentSubscriber);

    /**
     * Method to fetch subscriber details from database
     * @param email
     * @return
     */
    Subscriber getSubscriberByEmail(String email);
}
