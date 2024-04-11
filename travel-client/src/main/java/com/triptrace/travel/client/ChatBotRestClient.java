package com.triptrace.travel.client;

import com.triptrace.travel.object.bo.ChatBotRequestBO;
import com.triptrace.travel.object.bo.ChatBotResponseBO;
import com.triptrace.travel.object.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Class to get data from ChatGPT AI Model
 */
@Component
public class ChatBotRestClient extends BaseRestClient{
    @Value("${openai.chatgtp.api.key}")
    private String openaiApiKey;

    @Value("${openai.chatgtp.model}")
    private String model;

    @Value("${openai.chatgtp.max-completions}")
    private int maxCompletions;

    @Value("${openai.chatgtp.temperature}")
    private double temperature;

    @Value("${openai.chatgtp.max_tokens}")
    private int maxTokens;

    @Value("${openai.chatgtp.api.url}")
    private String apiUrl;

    @Bean
    public RestTemplate restTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });

        return restTemplate;
    }

    /**
     * Method to get chat response
     * @param prompt
     * @return
     */
    public ChatBotResponseBO getChatResponse(String prompt) {
        ChatBotRequestBO request = new ChatBotRequestBO(model,
                List.of(new MessageDTO("user", prompt)),
                maxCompletions,
                temperature,
                maxTokens);


        return  restTemplate().postForObject(apiUrl, request, ChatBotResponseBO.class);
    }

}
