package com.triptrace.travel.api.controller.resources;

import com.triptrace.travel.core.constants.MailType;
import com.triptrace.travel.dao.entities.Subscriber;
import com.triptrace.travel.mail.core.newsletter.NewsletterMail;
import com.triptrace.travel.object.converter.SubscriberConverter;
import com.triptrace.travel.object.converter.TopTravelDestinationConverter;
import com.triptrace.travel.object.dto.SubscriberDTO;
import com.triptrace.travel.object.dto.TopTravelDestinationDTO;
import com.triptrace.travel.service.home.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API Class for dashboard
 */
@RestController
@RequestMapping("rest/v1")
public class HomeAPI {
    private final HomeService homeService;
    private final NewsletterMail newsletterMail;

    @Autowired
    public HomeAPI(HomeService homeService, NewsletterMail newsletterMail) {
        this.homeService = homeService;
        this.newsletterMail = newsletterMail;
    }

    /**
     * API to get top travel destinations of the month w.r.t country
     * @param month
     * @param country
     * @return
     */
    @GetMapping("home")
    public List<TopTravelDestinationDTO> topTravelDestinations(@RequestParam(name = "month") String month,
                                                   @RequestParam(name = "country") String country){
        return TopTravelDestinationConverter.entityListToDTOList(homeService.getTopTravelDestinations(month, country));
    }

    /**
     * API to subscribe/unsubscribe newsletter
     * @param subscriberDTO
     * @return
     */
    @PostMapping("newsletter")
    public String subscribeToNewsletter(@Validated @RequestBody SubscriberDTO subscriberDTO){
        Subscriber subscriber = SubscriberConverter.dtoToEntity(subscriberDTO);
        homeService.subscribeEmailToNewsletter(subscriber);
        return "Subscribed to newsletter succesfully!!";
    }

    /**
     * Sample email API
     * @return
     */
    @GetMapping("email")
    public String unsubscribeToNewsletter(){
        newsletterMail.sendEmailNotification(MailType.WELCOME_EMAIL);
        return "Unsubscribed to Newsletter. You won't be hearing more from us :(";
    }
}
