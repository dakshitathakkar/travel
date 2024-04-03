package com.triptrace.travel.object.converter;

import com.triptrace.travel.core.constants.Month;
import com.triptrace.travel.core.utilities.NullUtilities;
import com.triptrace.travel.dao.entity.TopTravelDestination;
import com.triptrace.travel.object.dto.TopTravelDestinationDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TopTravelDestinationConverter {
    private TopTravelDestinationConverter() {}

    public static TopTravelDestinationDTO entityToDTO(TopTravelDestination topTravelDestination){
        TopTravelDestinationDTO topTravelDestinationDTO = new TopTravelDestinationDTO();
        topTravelDestinationDTO.setMonth(topTravelDestination.getMonth().value());
        topTravelDestinationDTO.setCountry(topTravelDestination.getCountry());
        topTravelDestinationDTO.setCityName(topTravelDestination.getCity());
        topTravelDestinationDTO.setStateName(topTravelDestination.getState());
        topTravelDestinationDTO.setDescription(topTravelDestination.getDescription());
        return topTravelDestinationDTO;
    }

    public static TopTravelDestination dtoToEntity(TopTravelDestinationDTO topTravelDestinationDTO){
        TopTravelDestination topTravelDestination = new TopTravelDestination();
        topTravelDestination.setCity(topTravelDestinationDTO.getCityName());
        topTravelDestination.setCountry(topTravelDestinationDTO.getCountry());
        topTravelDestination.setState(topTravelDestination.getState());
        topTravelDestination.setMonth(Month.valueOf(topTravelDestinationDTO.getMonth()));
        topTravelDestination.setDescription(topTravelDestinationDTO.getDescription());
        return topTravelDestination;
    }

    public static List<TopTravelDestinationDTO> entityListToDTOList(Collection<TopTravelDestination> destinations){
        return NullUtilities.isNull(destinations) ? null : destinations.stream()
                .map(TopTravelDestinationConverter::entityToDTO).collect(Collectors.toList());
    }

}
