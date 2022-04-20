package lesson41.mapper;

import lesson41.dto.DirectoryDto;
import lesson41.model.Directory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface DirectoryMapper {


    @Mapping(target = "regionId", source = "entity.regionId")
    @Mapping(target = "regionName", source = "entity.regionName")
    DirectoryDto toDto(Directory entity);

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
