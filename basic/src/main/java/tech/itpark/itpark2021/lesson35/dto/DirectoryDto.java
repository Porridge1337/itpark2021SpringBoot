package tech.itpark.itpark2021.lesson35.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DirectoryDto {

    @NotNull
    @Min(message = "Код регионов не может быть равен 0", value = 1)
    @Max(message = "Код региона не должен превышать 100", value = 100)
    private Long regionId;

    @NotNull
    @Size(min = 1, max = 120)
    private String regionName;

    public String getIdStr() {
        return String.format("dir_%s", regionId);
    }
}
