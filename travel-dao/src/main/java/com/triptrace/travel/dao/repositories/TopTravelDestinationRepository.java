package com.triptrace.travel.dao.repositories;

import com.triptrace.travel.core.constants.Month;
import com.triptrace.travel.dao.entities.TopTravelDestination;

import java.util.List;

public interface TopTravelDestinationRepository extends BaseRepository<TopTravelDestination, Integer> {

    /**
     * Method to find destinations based on month and country
     * @param month
     * @param country
     * @return
     */
    List<TopTravelDestination> findAllByMonthAndCountry(Month month, String country);
}
