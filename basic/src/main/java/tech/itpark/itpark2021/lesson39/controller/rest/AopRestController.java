package tech.itpark.itpark2021.lesson39.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.itpark2021.lesson39.dto.TownDirectoryDto;
import tech.itpark.itpark2021.lesson39.service.TownDirectoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AopRestController {

    private final TownDirectoryService service;

    @GetMapping("/city")
    public TownDirectoryDto getCityByName(@RequestParam String name) {
        return service.findByCityName(name).
                orElseThrow(() -> new IllegalArgumentException("Has no city with name " + name));
    }

    @GetMapping("/allCities")
    public List<TownDirectoryDto> getAllCities(){
        return service.findAllTowns();
    }

}
