package Task.SprintTaskSpringboot.mappers;

import Task.SprintTaskSpringboot.DTO.CourseCategoryDTO;
import Task.SprintTaskSpringboot.model.CourseCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseCategoryMapper {
    List<CourseCategoryDTO> toCourseCategoryDTOList(List<CourseCategory> courseCategories);
    CourseCategoryDTO toDTO(CourseCategory courseCategory);
    CourseCategory toEntity(CourseCategoryDTO courseCategoryDTO);
}
