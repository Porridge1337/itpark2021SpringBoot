package tech.itpark.itpark2021.lesson35.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DirectoryPageDto {

    private List<DirectoryDto> data;
    private int currentPage;
    private int totalPage;
    private boolean hasNext;
    private boolean hasPrevious;
}
