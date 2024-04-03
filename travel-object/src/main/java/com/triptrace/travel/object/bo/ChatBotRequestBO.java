package com.triptrace.travel.object.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.triptrace.travel.object.dto.MessageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatBotRequestBO {

    private String model;
    private List<MessageDTO> messages;
    private int n;
    private double temperature;
    private int max_tokens;
}
