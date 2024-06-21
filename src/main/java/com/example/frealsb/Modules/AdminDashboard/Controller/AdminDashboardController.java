package com.example.frealsb.Modules.AdminDashboard.Controller;

import com.example.frealsb.Modules.Blog.Service.IBlogService;
import com.example.frealsb.Modules.Event.Service.IEventService;
import com.example.frealsb.Modules.Location.Service.ILocationService;
import com.example.frealsb.Modules.User.Service.IUserService;
import com.example.frealsb.Util.Model.PaginationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dashboard")
public class AdminDashboardController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IEventService eventService;

    @GetMapping("")
    public String dashboard (){
        return "Layouts/Dashboard/index";
    }
    @GetMapping("mail_box")
    public String mailBox (){
        return "Layouts/Dashboard/mail_box";
    }

    @GetMapping("chat")
    public String chat (){
        return "Layouts/Dashboard/chat";
    }

    @GetMapping("invoice")
    public String invoice (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("user")
    public String userTable ( @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int limit,
                              @RequestParam(defaultValue = "desc", name = "sort") String sortDirection,
                              @RequestParam(defaultValue = "createdAt") String sortBy,
                              Model model){
        PaginationDTO paginationDTO = new PaginationDTO(page, limit, sortDirection, sortBy);
        model.addAttribute("users", userService.getAll(paginationDTO));
        return "Layouts/Dashboard/user_table";
    }

    @GetMapping("blog")
    public String blogTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("event")
    public String eventTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("culture")
    public String cultureTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("culture_category")
    public String cultureCategoryTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("food")
    public String foodTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("food_category")
    public String foodCategoryTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("food_feature")
    public String foodFeatureTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("location")
    public String locationTable (){
        return "Layouts/Dashboard/invoice";
    }
}
