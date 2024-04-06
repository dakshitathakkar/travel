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
     *
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

    Subscriber updateSubsriber(Subscriber subscriberParams, Subscriber currentSubscriber);

    Subscriber getSubscriberByEmail(String email);
}
