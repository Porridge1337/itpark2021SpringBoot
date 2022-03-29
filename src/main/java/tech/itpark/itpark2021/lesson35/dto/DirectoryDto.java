package tech.itpark.itpark2021.lesson35.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DirectoryDto {

    @NotNull
    @Size(min = 1, max = 2)
    private Long regionId;

    @NotNull
    @Size(min = 1, max = 2)
    private String regionName;
}
