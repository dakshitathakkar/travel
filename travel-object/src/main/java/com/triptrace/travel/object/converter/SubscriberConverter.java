package com.triptrace.travel.object.converter;

import com.triptrace.travel.core.utilities.NullUtilities;
import com.triptrace.travel.dao.entities.Subscriber;
import com.triptrace.travel.object.dto.SubscriberDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SubscriberConverter {

    private SubscriberConverter() {}

    public static SubscriberDTO entityToDTO(Subscriber subscriber){
        SubscriberDTO subscriberDTO = new SubscriberDTO();
        subscriberDTO.setSubscriberId(subscriber.getSubscriberId());
        subscriberDTO.setEmail(subscriber.getEmail());
        subscriberDTO.setStatus(subscriber.getStatus());
        return subscriberDTO;
    }

    public static Subscriber dtoToEntity(SubscriberDTO subscriberDTO){
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail(subscriberDTO.getEmail());
        subscriber.setStatus(subscriberDTO.getStatus());
        return subscriber;
    }

    public static List<SubscriberDTO> entityListToDTOList(Collection<Subscriber> subscribers){
        return NullUtilities.isNull(subscribers) ? null : subscribers.stream()
                .map(SubscriberConverter::entityToDTO).collect(Collectors.toList());
    }


}
