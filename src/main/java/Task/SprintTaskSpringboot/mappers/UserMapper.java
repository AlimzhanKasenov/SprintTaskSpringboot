package Task.SprintTaskSpringboot.mappers;

import Task.SprintTaskSpringboot.DTO.UserDTO;
import Task.SprintTaskSpringboot.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<UserDTO> toUserDTOList(List<User> users);
    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
