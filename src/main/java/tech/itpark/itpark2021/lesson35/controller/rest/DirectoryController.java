package tech.itpark.itpark2021.lesson35.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.itpark.itpark2021.lesson35.dto.ResultDto;
import tech.itpark.itpark2021.lesson35.service.DirectoryService;

@Controller
@RequiredArgsConstructor
public class DirectoryController {

    private final DirectoryService service;

    @DeleteMapping("/directory/delete/{regId}")
    public ResponseEntity<?> delete(@PathVariable("regId") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok(new ResultDto());
    }
}
