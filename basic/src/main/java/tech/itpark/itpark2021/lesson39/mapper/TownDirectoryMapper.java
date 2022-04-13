package tech.itpark.itpark2021.lesson39.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.itpark.itpark2021.lesson39.model.TownDirectory;
import tech.itpark.itpark2021.lesson39.dto.TownDirectoryDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface TownDirectoryMapper {

    @Mapping(target = "id", source = "townDirectory.id")
    @Mapping(target = "cityName", source = "townDirectory.cityName")
    @Mapping(target = "cityCode", source = "townDirectory.cityCode")
    @Mapping(target = "population", source = "townDirectory.population")
    TownDirectoryDto toDto(TownDirectory townDirectory);

    @Mapping(target = "id", source = "townDirectoryDto.id")
    @Mapping(target = "cityName", source = "townDirectoryDto.cityName")
    @Mapping(target = "cityCode", source = "townDirectoryDto.cityCode")
    @Mapping(target = "population", source = "townDirectoryDto.population")
    TownDirectory toEntity(TownDirectoryDto townDirectoryDto);

    default Optional<TownDirectoryDto> toOptionalDto(Optional<TownDirectory> entity) {
        return entity.map(this::toDto);
    }

    default List<TownDirectoryDto> toDtos(List<TownDirectory> entities){
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
