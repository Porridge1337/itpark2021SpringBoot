package tech.itpark.itpark2021.lesson35.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
}
