package com.triptrace.travel.service.home;

import com.triptrace.travel.client.GeminiRestClient;
import com.triptrace.travel.core.constants.ApplicationConstant;
import com.triptrace.travel.object.bo.GeminiResponseBO;
import com.triptrace.travel.object.dto.TravelItineraryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelItineraryServiceImpl implements TravelItineraryService{

    private final GeminiRestClient geminiRestClient;
    @Autowired
    public TravelItineraryServiceImpl(GeminiRestClient geminiRestClient) {
        this.geminiRestClient = geminiRestClient;
    }

    @Override
    public TravelItineraryDTO getTravelItineraryWithFilters(TravelItineraryDTO travelItineraryDTO) {
//        "Give me a travel itinerary with the following filter: Month: %s, " +
//                "Continent: %s, Country: %s, Weather: %s, Days: %s, Budget: %s " +
//                "Travelling with: %s, Resident of:%s";
        String prompt = String.format(ApplicationConstant.TRAVEL_ITINERARY_PROMPT,travelItineraryDTO.getMonth(),travelItineraryDTO.getContinent(),
                travelItineraryDTO.getCountry(),travelItineraryDTO.getWeather(),travelItineraryDTO.getDays(),travelItineraryDTO.getBudget(),
                travelItineraryDTO.getTravelPartners(),travelItineraryDTO.getResidentOf());
        GeminiResponseBO geminiResponseBO = geminiRestClient.getChatResponse(prompt);
        travelItineraryDTO.setResponse(geminiResponseBO.getCandidates().get(0).getContent().getParts().get(0).getText());
        return travelItineraryDTO;
    }
}
