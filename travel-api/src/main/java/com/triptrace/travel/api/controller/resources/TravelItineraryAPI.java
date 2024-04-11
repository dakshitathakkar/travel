package com.triptrace.travel.api.controller.resources;

import com.triptrace.travel.object.dto.TravelItineraryDTO;
import com.triptrace.travel.service.home.TravelItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Class for travel itinerary
 */
@RestController
@RequestMapping("rest/v1")
public class TravelItineraryAPI {
    private final TravelItineraryService travelItineraryService;
    @Autowired
    public TravelItineraryAPI(TravelItineraryService travelItineraryService) {
        this.travelItineraryService = travelItineraryService;
    }

    /**
     * API to get travel itinerary w.r.t. filters
     * @param travelItineraryDTO
     * @return
     */
    @GetMapping("travelitinerary")
    public TravelItineraryDTO travelItineraryDTO(@Validated @RequestBody TravelItineraryDTO travelItineraryDTO){
        return travelItineraryService.getTravelItineraryWithFilters(travelItineraryDTO);
    }
}
