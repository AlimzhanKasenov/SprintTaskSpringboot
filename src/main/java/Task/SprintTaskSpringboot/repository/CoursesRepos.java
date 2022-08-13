package Task.SprintTaskSpringboot.repository;

import Task.SprintTaskSpringboot.model.CourseCategory;
import Task.SprintTaskSpringboot.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CoursesRepos extends JpaRepository<Courses, Long> {
}
