package lesson41.controller.rest;

import lesson41.dto.DirectoryDto;
import lesson41.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DirectoryRestController {

   private final DirectoryService service;

    @DeleteMapping("/directory/delete/{id}")
    public ResponseEntity<?> deleteDirectory(@PathVariable(name = "id") String regionId) {
        service.delete(regionId);
        return ResponseEntity.ok(new DirectoryDto());
    }

}
