package Task.SprintTaskSpringboot.DTO;

import Task.SprintTaskSpringboot.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private List<Role> roles;
}
