package com.example.frealsb.Modules.AdminDashboard.Controller;

import com.example.frealsb.Const.ErrorConstants;
import com.example.frealsb.Const.ToastConstants;
import com.example.frealsb.Modules.Blog.Service.IBlogService;
import com.example.frealsb.Modules.Event.Service.IEventService;
import com.example.frealsb.Modules.Food.Model.Food;
import com.example.frealsb.Modules.Food.Service.IFoodService;
import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import com.example.frealsb.Modules.FoodCategory.Service.IFoodCategoryService;
import com.example.frealsb.Modules.Location.Model.Location;
import com.example.frealsb.Modules.Location.Service.ILocationService;
import com.example.frealsb.Modules.User.Model.User;
import com.example.frealsb.Modules.User.Service.IUserService;
import com.example.frealsb.Util.Model.PaginationDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dashboard")
public class AdminDashboardController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IFoodService foodService;
    @Autowired
    private IFoodCategoryService foodCategoryService;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IEventService eventService;

    @GetMapping("")
    public String dashboard (){
        return "Layouts/Dashboard/index";
    }
    @GetMapping("/mail_box")
    public String mailBox (){
        return "Layouts/Dashboard/mail_box";
    }

    @GetMapping("/chat")
    public String chat (){
        return "Layouts/Dashboard/chat";
    }

    @GetMapping("/invoice")
    public String invoice (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("/user")
    public String userTable ( @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int limit,
                              @RequestParam(defaultValue = "desc", name = "sort") String sortDirection,
                              @RequestParam(defaultValue = "createdAt") String sortBy,
                              Model model){
        model.addAttribute("user", new User());
        PaginationDTO paginationDTO = new PaginationDTO(page, limit, sortDirection, sortBy);
        model.addAttribute("users", userService.getAll(paginationDTO));
        return "Layouts/Dashboard/user_table";
    }

    @GetMapping("/blog")
    public String blogTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("/event")
    public String eventTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("/culture")
    public String cultureTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("/culture_category")
    public String cultureCategoryTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("/food")
    public String foodTable (@RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "10") int limit,
                             @RequestParam(defaultValue = "desc", name = "sort") String sortDirection,
                             @RequestParam(defaultValue = "createdAt") String sortBy,
                             Model model){
        model.addAttribute("food", new Food());
        PaginationDTO paginationDTO = new PaginationDTO(page, limit, sortDirection, sortBy);
        model.addAttribute("foods", foodService.getAll(paginationDTO));
        return "Layouts/Dashboard/food_table";
    }

    @GetMapping("/food_category")
    public String foodCategoryTable (@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "10") int limit,
                                     @RequestParam(defaultValue = "desc", name = "sort") String sortDirection,
                                     @RequestParam(defaultValue = "createdAt") String sortBy,
                                     Model model){
        model.addAttribute("food_category", new FoodCategory());
        PaginationDTO paginationDTO = new PaginationDTO(page, limit, sortDirection, sortBy);
        model.addAttribute("food_categories", foodCategoryService.getAll(paginationDTO));
        return "Layouts/Dashboard/food_category_table";
    }

    @GetMapping("/food_feature")
    public String foodFeatureTable (){
        return "Layouts/Dashboard/invoice";
    }

    @GetMapping("/location")
    public String locationTable (@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int limit,
                                 @RequestParam(defaultValue = "desc", name = "sort") String sortDirection,
                                 @RequestParam(defaultValue = "createdAt") String sortBy,
                                 Model model){
        model.addAttribute("location", new Location());
        PaginationDTO paginationDTO = new PaginationDTO(page, limit, sortDirection, sortBy);
        model.addAttribute("locations", locationService.getAll(paginationDTO));
        return "Layouts/Dashboard/location_table";
    }

    /**
     * ======= START OF REGION =======
     * ========== API CRUD ===========
     */
    @GetMapping("/edit_category/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getFoodCategory(@PathVariable String id) {
        FoodCategory existingCategory = foodCategoryService.getFoodCategory(id);
        if (existingCategory != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("foodCategory", existingCategory);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(404).body(Map.of("status", "error", "message", "Food category not found"));
        }
    }

    // Edit FoodCategory
    @PutMapping("/edit_category/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> editFoodCategory(@PathVariable String id, @Validated @RequestBody FoodCategory foodCategory) {
        FoodCategory existingCategory = foodCategoryService.getFoodCategory(id);
        if (existingCategory != null) {
            existingCategory.setTitle(foodCategory.getTitle());
            foodCategoryService.updateFoodCategory(existingCategory);
            return ResponseEntity.ok(Map.of("status", "success", "message", "Food category updated successfully"));
        } else {
            return ResponseEntity.status(404).body(Map.of("status", "error", "message", "Food category not found"));
        }
    }

    // Delete FoodCategory
    @DeleteMapping("/delete_category/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteFoodCategory(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            FoodCategory isDeleted = foodCategoryService.deleteFoodCategory(id);
            if (isDeleted != null) {
                response.put("status", "success");
                response.put("message", "Food category deleted successfully");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "error");
                response.put("message", "Food category not found");
                return ResponseEntity.status(404).body(response);
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    // Create FoodCategory
    @PostMapping("/create_category")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createFoodCategory(@Validated @RequestBody FoodCategory foodCategory) {
        Map<String, Object> response = new HashMap<>();
        foodCategoryService.addFoodCategory(foodCategory);
        response.put("status", "success");
        response.put("message", "Food category created successfully");
        return ResponseEntity.ok(response);
    }

    // Get Food by ID
    @GetMapping("/edit_food/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getFood(@PathVariable String id) {
        Food existingFood = foodService.getFood(id);
        if (existingFood != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("food", existingFood);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(404).body(Map.of("status", "error", "message", "Food not found"));
        }
    }

    // Edit Food
    @PutMapping("/edit_food/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> editFood(@PathVariable String id, @Validated @ModelAttribute Food food) {
        Food existingFood = foodService.getFood(id);
        if (existingFood != null) {
            existingFood.setTitle(food.getTitle());
            existingFood.setDescription(food.getDescription());
            existingFood.setLocation(food.getLocation());
            existingFood.setFoodFeatured(food.getFoodFeatured());
            existingFood.setFoodCategory(food.getFoodCategory());
            existingFood.setPrice(food.getPrice());
            existingFood.setRating(food.getRating());
            existingFood.setOpeningHours(food.getOpeningHours());
            existingFood.setCloseHours(food.getCloseHours());
            existingFood.setContactNumber(food.getContactNumber());
            existingFood.setMapAddress(food.getMapAddress());
            foodService.updateFood(existingFood);
            return ResponseEntity.ok(Map.of("status", "success", "message", "Food updated successfully"));
        } else {
            return ResponseEntity.status(404).body(Map.of("status", "error", "message", "Food not found"));
        }
    }

    // Delete Food
    @DeleteMapping("/delete_food/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteFood(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Food isDeleted = foodService.deleteFood(id);
            if (isDeleted != null) {
                response.put("status", "success");
                response.put("message", "Food deleted successfully");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "error");
                response.put("message", "Food not found");
                return ResponseEntity.status(404).body(response);
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    // Create Food
    @PostMapping("/create_food")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createFood(@Validated @ModelAttribute Food food) {
        Map<String, Object> response = new HashMap<>();
        foodService.addFood(food);
        response.put("status", "success");
        response.put("message", "Food created successfully");
        return ResponseEntity.ok(response);
    }

    // Location
    @GetMapping("/edit_location/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getLocation(@PathVariable String id) {
        Location existingLocation = locationService.getLocationById(id);
        if (existingLocation != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("location", existingLocation); // Include location details in the response
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(404).body(Map.of("status", "error", "message", "Location not found"));
        }
    }
    @PutMapping("/edit_location/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> editLocation(@PathVariable String id, @Validated @ModelAttribute Location location) {
        Location existingLocation = locationService.getLocationById(id);
        if (existingLocation != null) {
            existingLocation.setCity(location.getCity());
            existingLocation.setProvince(location.getProvince());
            existingLocation.setFeatures(location.getFeatures());
            locationService.saveLocation(existingLocation);
            return ResponseEntity.ok(Map.of("status", "success", "message", "Location updated successfully"));
        } else {
            return ResponseEntity.status(404).body(Map.of("status", "error", "message", "Location not found"));
        }
    }

    @DeleteMapping("/delete_location/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteLocation(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Location isDeleted = locationService.deleteLocation(id);
            if (isDeleted != null) {
                response.put("status", "success");
                response.put("message", "Location deleted successfully");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "error");
                response.put("message", "Location not found");
                return ResponseEntity.status(404).body(response);
            }
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @PostMapping("/create_location")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createLocation(@Valid @ModelAttribute Location location) {
        Map<String, Object> response = new HashMap<>();
        if (locationService.existsByCityAndProvinceAndFeatures(location)) {
            response.put(ErrorConstants.status, ErrorConstants.statusError);
            response.put(ErrorConstants.message, ErrorConstants.locationExits);
            return ResponseEntity.badRequest().body(response);
        }
        locationService.saveLocation(location);
        response.put(ErrorConstants.status,ErrorConstants.statusSuccess);
        return ResponseEntity.ok(response);
    }

    // User
    @PostMapping("/user_lock/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> userLock(@PathVariable("id") String userId) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean isAdmin = userService.handleLockUser(userId);
            if (!isAdmin) {
                response.put(ErrorConstants.status, ErrorConstants.statusError);
                response.put(ErrorConstants.message, ToastConstants.cantLockUser);
                return ResponseEntity.badRequest().body(response);
            }
            response.put(ErrorConstants.status,ErrorConstants.statusSuccess);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put(ErrorConstants.status, ErrorConstants.statusError);
            response.put(ErrorConstants.message, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/create_user")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createUser(@Valid @ModelAttribute User user) {
        Map<String, Object> response = new HashMap<>();
        if (userService.existsByEmail(user.getEmail())) {
            response.put(ErrorConstants.status, ErrorConstants.statusError);
            response.put(ErrorConstants.message, ErrorConstants.emailExits);
            return ResponseEntity.badRequest().body(response);
        }
        userService.createUser(user);
        response.put(ErrorConstants.status,ErrorConstants.statusSuccess);
        return ResponseEntity.ok(response);
    }
    /**
     * ======= END OF REGION =======
     */
}
