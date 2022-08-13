package Task.SprintTaskSpringboot.repository;

import Task.SprintTaskSpringboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepos extends JpaRepository<Role, Long> {
}