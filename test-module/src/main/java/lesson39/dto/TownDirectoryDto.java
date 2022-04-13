package lesson39.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TownDirectoryDto {

    @NotNull
    private long id;
    @NotEmpty
    private String cityName;
    @NotEmpty
    private int cityCode;
    @NotEmpty
    private long population;

}
