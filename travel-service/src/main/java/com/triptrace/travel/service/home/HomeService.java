package com.triptrace.travel.service.home;

import com.triptrace.travel.core.constants.Month;
import com.triptrace.travel.dao.entity.TopTravelDestination;
import com.triptrace.travel.object.dto.TopTravelDestinationDTO;

import java.util.List;

public interface HomeService {

    /**
     * Get all travel destinations
     * @param month
     * @param country
     * @return
     */
    List<TopTravelDestinationDTO> getTopTravelDestinations(String month, String country);

    /**
     *
     * @param month
     * @param country
     * @return
     */
    List<TopTravelDestination> getAllDestinationsByMonthAndCountry(Month month, String country);
}
