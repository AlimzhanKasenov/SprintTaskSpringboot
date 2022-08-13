package Task.SprintTaskSpringboot.repository;

import Task.SprintTaskSpringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepos extends JpaRepository<User, Long> {
    User findAllByEmail(String str);
}
