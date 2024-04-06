package com.triptrace.travel.service.home;

import com.triptrace.travel.client.ChatBotRestClient;
import com.triptrace.travel.core.constants.ApplicationConstant;
import com.triptrace.travel.core.constants.Month;
import com.triptrace.travel.core.utilities.NullUtilities;
import com.triptrace.travel.dao.entities.Subscriber;
import com.triptrace.travel.dao.entities.TopTravelDestination;
import com.triptrace.travel.dao.repositories.SubscriberRepository;
import com.triptrace.travel.dao.repositories.TopTravelDestinationRepository;
import com.triptrace.travel.object.bo.ChatBotResponseBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional(readOnly = true)
public class HomeServiceImpl implements HomeService{
    private final ChatBotRestClient chatBotRestClient;
    private final TopTravelDestinationRepository topTravelDestinationRepository;
    private final SubscriberRepository subscriberRepository;

    @Autowired
    public HomeServiceImpl(ChatBotRestClient chatBotRestClient, TopTravelDestinationRepository topTravelDestinationRepository, SubscriberRepository subscriberRepository) {
        this.chatBotRestClient = chatBotRestClient;
        this.topTravelDestinationRepository = topTravelDestinationRepository;
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public List<TopTravelDestination> getTopTravelDestinations(String month, String country) {

        List<TopTravelDestination> destinations = getAllDestinationsByMonthAndCountry(Month.valueOf(month),country);
        if (CollectionUtils.isEmpty(destinations)){
            destinations =  getDestinationsFromChatBOT(month,country);
        }
       return destinations;
    }

    @Transactional
    private List<TopTravelDestination> getDestinationsFromChatBOT(String month, String country) {
        List<TopTravelDestination> topTravelDestinationDTOList = new LinkedList<>();
        String prompt = String.format(ApplicationConstant.HOME_API_PROMPT,month,country);
        ChatBotResponseBO chatBotResponseBO = chatBotRestClient.getChatResponse(prompt);
        TopTravelDestination topTravelDestinationDTO = new TopTravelDestination();
          topTravelDestinationDTO.setContent(chatBotResponseBO.getChoices().get(0).getMessage().getContent());
//        topTravelDestinationDTO.setContent(ApplicationConstant.HOME_API_SAMPLE_OUTPUT_TEST);


        String[] contents = topTravelDestinationDTO.getContent().split(ApplicationConstant.NEXT_LINE_DELIMITER);
        Arrays.stream(contents).forEach(content ->{
            TopTravelDestination topTravelDestination = new TopTravelDestination();
            String regex = ApplicationConstant.CHATBOT_OUTPUT_REGEX;
            Matcher matcher = Pattern.compile(regex).matcher(content);
            if (matcher.find()){
                topTravelDestination.setCity(matcher.group(1));
                topTravelDestination.setState(matcher.group(2));
                topTravelDestination.setDescription(matcher.group(3));
                topTravelDestination.setMonth(Month.valueOf(month));
                topTravelDestination.setCountry(country);
                topTravelDestinationDTOList.add(topTravelDestination);
                topTravelDestinationRepository.save(topTravelDestination);
            }

        });
      return topTravelDestinationDTOList;
    }

    @Override
    public List<TopTravelDestination> getAllDestinationsByMonthAndCountry(Month month, String country) {
        return topTravelDestinationRepository.findAllByMonthAndCountry(month,country);
    }

    @Override
    @Transactional
    public void subscribeEmailToNewsletter(Subscriber subscriber) {
        Subscriber currentSubscriber = getSubscriberByEmail(subscriber.getEmail());
        if (NullUtilities.isNull(currentSubscriber)){
            currentSubscriber = new Subscriber();

        }
        updateSubsriber(subscriber, currentSubscriber);
    }

    @Override
    @Transactional
    public Subscriber updateSubsriber(Subscriber subscriberParams, Subscriber currentSubscriber) {
        currentSubscriber.setEmail(subscriberParams.getEmail());
        currentSubscriber.setStatus(subscriberParams.getStatus());
        return subscriberRepository.save(currentSubscriber);
    }

    @Override
    public Subscriber getSubscriberByEmail(String email) {
        return subscriberRepository.findAllByEmail(email);
    }
}
