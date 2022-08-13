package Task.SprintTaskSpringboot.repository;

import Task.SprintTaskSpringboot.model.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CourseCategoryRepos extends JpaRepository<CourseCategory, Long> {
}
