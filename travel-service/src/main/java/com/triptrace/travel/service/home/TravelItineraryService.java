package com.triptrace.travel.service.home;

import com.triptrace.travel.object.dto.TravelItineraryDTO;

public interface TravelItineraryService {

    /**
     * Method to get travel itinerary from AI based on the provided filters
     * @param travelItineraryDTO
     * @return
     */
    TravelItineraryDTO getTravelItineraryWithFilters(TravelItineraryDTO travelItineraryDTO);
}
