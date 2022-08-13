package Task.SprintTaskSpringboot.API;

import Task.SprintTaskSpringboot.DTO.CoursesDTO;
import Task.SprintTaskSpringboot.model.CourseCategory;
import Task.SprintTaskSpringboot.model.Courses;
import Task.SprintTaskSpringboot.model.User;
import Task.SprintTaskSpringboot.service.CourseCategoryService;
import Task.SprintTaskSpringboot.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CoursesService coursesService;
    private final CourseCategoryService courseCategoryService;

    @GetMapping("/")
    public String mainPage(){
        return "MainPage";
    }

    @GetMapping("/author")
    public String authorization(){
        return "Authorization";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String getProfilePage(Model model){
        List<CoursesDTO> coursesDTOS = coursesService.getAllCoursers();
        model.addAttribute("courses", coursesDTOS);
        List<CourseCategory> categories = courseCategoryService.getCategories();
        model.addAttribute("coursModal", categories);
        return "profilePage";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/getCourcById/{id}")
    public String getCourcById(@PathVariable(name = "id") long id, Model model){
        List<CourseCategory> category = new ArrayList<>();
        CoursesDTO coursesDTO = coursesService.getByIdCours(id);
        model.addAttribute("cours", coursesDTO);
        return "DetailsPageCours";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/addCours")
    public String addCours(@RequestParam(name = "name") String name,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "price") int price,
                           @RequestParam(name = "rating") double rating,
                           @RequestParam(name = "category") Long category){
        User author = getCurrentUser();
        CourseCategory cour = courseCategoryService.getCategoryById(category);
        List<CourseCategory> courseCategories = new ArrayList<>();
        courseCategories.add(cour);
        Courses newCours = new Courses(null, name, description, price, rating, author, courseCategories);
        coursesService.addCours(newCours);
        return "redirect:/profile";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/deletCours")
    public String deletCours(@RequestParam(name = "id") Long id){
        coursesService.deletCours(id);
        return "redirect:/profile";
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            return user;
        }
        return null;
    }
}