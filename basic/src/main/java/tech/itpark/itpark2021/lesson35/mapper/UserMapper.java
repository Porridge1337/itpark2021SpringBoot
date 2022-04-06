package tech.itpark.itpark2021.lesson35.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tech.itpark.itpark2021.lesson35.dto.UserDto;
import tech.itpark.itpark2021.lesson35.model.User;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "login", source = "user.login")
    @Mapping(target = "password", source = "user.password")
    @Mapping(target = "status", source = "user.status")
    @Mapping(target = "role", source = "user.role")
    UserDto toDto(User user);

    @Mapping(target = "id", source = "userDto.id")
    @Mapping(target = "login", source = "userDto.login")
    @Mapping(target = "password", source = "userDto.password")
    @Mapping(target = "status", source = "userDto.status")
    @Mapping(target = "role", source = "userDto.role")
    User toEntity(UserDto userDto);

}