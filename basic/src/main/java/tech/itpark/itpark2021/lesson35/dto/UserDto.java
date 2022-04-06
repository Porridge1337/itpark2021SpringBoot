package tech.itpark.itpark2021.lesson35.dto;

import lombok.Data;
import tech.itpark.itpark2021.lesson35.model.type.Status;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserDto {

    @NotNull
    private long id;
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
    private Status status;
    private List<RoleDto> role;

}
