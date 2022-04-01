package tech.itpark.itpark2021.lesson35.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.itpark.itpark2021.lesson35.dto.DirectoryDto;
import tech.itpark.itpark2021.lesson35.model.Directory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface DirectoryMapper {

    @Mapping(target = "regionId", source = "directory.regionId")
    @Mapping(target = "regionName", source = "directory.regionName")
    DirectoryDto toDto(Directory directory);

    @Mapping(target = "regionId", source = "dto.regionId")
    @Mapping(target = "regionName", source = "dto.regionName")
    Directory toEntity(DirectoryDto dto);

    default List<DirectoryDto> toDtos(List<Directory> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<DirectoryDto> toOptionalDto(Optional<Directory> entity) {
        return entity.map(this::toDto);
    }
}
