package tech.itpark.itpark2021.lesson36.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenApiController {

    @GetMapping("/test")
    @Operation(summary = "Приветсвенный сервис")
    public String hello(@Parameter(description = "Инициатор запроса", required = true) @RequestParam String initiator) {
        return String.format("Hello, %s", initiator);
    }

}
