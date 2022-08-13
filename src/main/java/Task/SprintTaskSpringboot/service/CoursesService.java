package Task.SprintTaskSpringboot.service;

import Task.SprintTaskSpringboot.DTO.CoursesDTO;
import Task.SprintTaskSpringboot.mappers.CoursesMapper;
import Task.SprintTaskSpringboot.model.Courses;
import Task.SprintTaskSpringboot.repository.CoursesRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesService {

    private final CoursesMapper coursesMapper;
    private final CoursesRepos coursesRepos;

    public List<CoursesDTO> getAllCoursers(){
        return coursesMapper.toCursesDTOList(coursesRepos.findAll());
    }

    public CoursesDTO getByIdCours(Long id){
        return coursesMapper.toDTO(coursesRepos.getById(id));
    }

    public Courses addCours(Courses courses){
        if (courses != null){
            return coursesRepos.save(courses);
        }
        return null;
    }

    public void deletCours(Long id){
            coursesRepos.deleteById(id);
    }
}
