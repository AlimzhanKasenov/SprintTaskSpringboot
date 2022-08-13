package Task.SprintTaskSpringboot.service;

import Task.SprintTaskSpringboot.DTO.CourseCategoryDTO;
import Task.SprintTaskSpringboot.model.CourseCategory;
import Task.SprintTaskSpringboot.model.Courses;
import Task.SprintTaskSpringboot.repository.CourseCategoryRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCategoryService {
    private final CourseCategoryRepos categoryRepos;


    public CourseCategory getCategoryById(Long id){
        return categoryRepos.findById(id).orElse(null);
    }
    public List<CourseCategory> getCategories(){
        return categoryRepos.findAll();
    }
}
