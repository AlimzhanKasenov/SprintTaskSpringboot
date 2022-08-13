package Task.SprintTaskSpringboot.mappers;

import Task.SprintTaskSpringboot.DTO.CoursesDTO;
import Task.SprintTaskSpringboot.model.Courses;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoursesMapper {
    List<CoursesDTO> toCursesDTOList(List<Courses> courses);
    CoursesDTO toDTO(Courses courses);
    Courses toEntity(CoursesDTO coursesDTO);
}
