package Task.SprintTaskSpringboot.rest;

import Task.SprintTaskSpringboot.DTO.CoursesDTO;
import Task.SprintTaskSpringboot.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cours")
@CrossOrigin
@RequiredArgsConstructor
public class RestControll {

    private final CoursesService coursesService;

    @GetMapping
    public ResponseEntity<List<CoursesDTO>> getAllCoursers(){
        return new ResponseEntity<>(coursesService.getAllCoursers(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/courses/{id}")
    public ResponseEntity<CoursesDTO> getCoursById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(coursesService.getByIdCours(id), HttpStatus.OK);
    }
}
