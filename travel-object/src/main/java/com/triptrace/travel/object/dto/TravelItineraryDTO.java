package com.triptrace.travel.object.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelItineraryDTO {
    private String month;
    private String continent;
    private String country;
    private String weather;
    private Integer days;
    private String budget;
    private String travelPartners;
    private String residentOf;
    private String response;
}
