package tech.itpark.itpark2021.lesson35.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tech.itpark.itpark2021.lesson35.dto.RoleDto;
import tech.itpark.itpark2021.lesson35.model.Role;

import java.util.List;
import java.util.stream.Collectors;

@Mapper()
public interface RoleMapper {

    RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);

    @Mapping(target = "id", source = "role.id")
    @Mapping(target = "name", source = "role.name")
    @Mapping(target = "user", source = "role.user", ignore = true)
    RoleDto toDto(Role role);


    default List<RoleDto> toDtos(List<Role> entities) {
        return entities.stream().map(ROLE_MAPPER::toDto).collect(Collectors.toList());
    }
}
