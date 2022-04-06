package tech.itpark.itpark2021.lesson35.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDto {

    private long id;
    private String name;
    private List<UserDto> user;
}
