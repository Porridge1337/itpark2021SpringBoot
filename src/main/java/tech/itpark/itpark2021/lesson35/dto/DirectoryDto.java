package tech.itpark.itpark2021.lesson35.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DirectoryDto {

    @NotNull
    @Max(10)
    private Long regionId;

    @NotNull
    @Size(min = 1, max = 120)
    private String regionName;
}
