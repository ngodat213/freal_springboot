package com.example.frealsb.Modules.Location.Controller;

import com.example.frealsb.Modules.Culture.Service.ICultureService;
import com.example.frealsb.Modules.Event.Service.IEventService;
import com.example.frealsb.Modules.Food.Service.IFoodService;
import com.example.frealsb.Modules.Location.Service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IFoodService foodService;
    @Autowired
    private IEventService eventService;
    @Autowired
    private ICultureService cultureService;

    @GetMapping("/")
    public String location(Model model) {
//        model.addAttribute("locations", new RequestRole());
        return "Layouts/Location/index";
    }
}
