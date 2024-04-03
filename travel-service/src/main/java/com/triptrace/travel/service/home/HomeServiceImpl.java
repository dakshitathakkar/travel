package com.triptrace.travel.service.home;

import com.triptrace.travel.client.ChatBotRestClient;
import com.triptrace.travel.core.constants.ApplicationConstant;
import com.triptrace.travel.core.constants.Month;
import com.triptrace.travel.core.utilities.NullUtilities;
import com.triptrace.travel.dao.entity.TopTravelDestination;
import com.triptrace.travel.dao.repository.TopTravelDestinationRepository;
import com.triptrace.travel.object.bo.ChatBotResponseBO;
import com.triptrace.travel.object.dto.TopTravelDestinationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HomeServiceImpl implements HomeService{
    private final ChatBotRestClient chatBotRestClient;
    private final TopTravelDestinationRepository topTravelDestinationRepository;

    @Autowired
    public HomeServiceImpl(ChatBotRestClient chatBotRestClient, TopTravelDestinationRepository topTravelDestinationRepository) {
        this.chatBotRestClient = chatBotRestClient;
        this.topTravelDestinationRepository = topTravelDestinationRepository;
    }

    @Override
    public List<TopTravelDestinationDTO> getTopTravelDestinations(String month, String country) {

        List<TopTravelDestination> destinations = getAllDestinationsByMonthAndCountry(Month.valueOf(month),country);
        if (NullUtilities.isNull(destinations)){
            getDestinationsFromChatBOT(month,country);
        }
        List<TopTravelDestinationDTO> topTravelDestinationDTOList = new LinkedList<>();
        String prompt = String.format(ApplicationConstant.HOME_API_PROMPT,month,country);
        ChatBotResponseBO chatBotResponseBO = chatBotRestClient.getChatResponse(prompt);
        TopTravelDestinationDTO topTravelDestinationDTO = new TopTravelDestinationDTO();
      //  topTravelDestinationDTO.setContent(chatBotResponseBO.getChoices().get(0).getMessage().getContent());
            topTravelDestinationDTO.setContent(ApplicationConstant.HOME_API_SAMPLE_OUTPUT_TEST);
       // topTravelDestinationDTOList.add(topTravelDestinationDTO);

       String[] contents = topTravelDestinationDTO.getContent().split("\\n");
        Arrays.stream(contents).forEach(content ->{
            TopTravelDestinationDTO topTravelDestination = new TopTravelDestinationDTO();
            String regex = "(\\w+),\\s(\\w+)\\s-\\s(.*)";
            Matcher matcher = Pattern.compile(regex).matcher(content);
            if (matcher.find()){
                topTravelDestination.setCityName(matcher.group(1));
                topTravelDestination.setStateName(matcher.group(2));
                topTravelDestination.setDescription(matcher.group(3));
                topTravelDestinationDTOList.add(topTravelDestination);
            }

        });
        System.out.println(topTravelDestinationDTOList.size());
        return topTravelDestinationDTOList;
    }

    private void getDestinationsFromChatBOT(String month, String country) {
    }

    @Override
    public List<TopTravelDestination> getAllDestinationsByMonthAndCountry(Month month, String country) {
        return topTravelDestinationRepository.findAllByMonthAndCountry(month,country);
    }
}
