package Task.SprintTaskSpringboot.DTO;

import Task.SprintTaskSpringboot.model.CourseCategory;
import Task.SprintTaskSpringboot.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoursesDTO {
    private Long id;
    private String name;
    private String description;
    private String price;
    private Double rating;
    private UserDTO author;
    private List<CourseCategory> category;
}
