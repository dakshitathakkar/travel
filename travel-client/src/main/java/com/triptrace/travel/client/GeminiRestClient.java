package com.triptrace.travel.client;

import com.triptrace.travel.object.bo.ContentBO;
import com.triptrace.travel.object.bo.GeminiRequestBO;
import com.triptrace.travel.object.bo.GeminiResponseBO;
import com.triptrace.travel.object.bo.PartBO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeminiRestClient extends BaseRestClient{
   @Value("${gemini.api.url}")
    private String apiUrl;

   public GeminiResponseBO getChatResponse(String text){
       PartBO partBO = new PartBO(text);
       ContentBO contentBO = new ContentBO(List.of(partBO));
       GeminiRequestBO request = new GeminiRequestBO(
               List.of(contentBO));

       return getRestTemplate().postForObject(apiUrl,request, GeminiResponseBO.class);
   }

}
