package Task.SprintTaskSpringboot.mappers;

import Task.SprintTaskSpringboot.DTO.RoleDTO;
import Task.SprintTaskSpringboot.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    List<RoleDTO> toRolesDTOList(List<Role> roles);
    RoleDTO toDTO(Role role);
    Role toEntity(RoleDTO roleDTO);
}
