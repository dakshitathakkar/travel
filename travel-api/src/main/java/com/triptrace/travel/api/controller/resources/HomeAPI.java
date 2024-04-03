package com.triptrace.travel.api.controller.resources;

import com.triptrace.travel.object.dto.TopTravelDestinationDTO;
import com.triptrace.travel.service.home.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/v1")
public class HomeAPI {
    private final HomeService homeService;

    @Autowired
    public HomeAPI(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("home")
    public List<TopTravelDestinationDTO> getSample(@RequestParam(name = "month") String month,
                                                   @RequestParam(name = "country") String country){
        return homeService.getTopTravelDestinations(month, country);
    }
}
