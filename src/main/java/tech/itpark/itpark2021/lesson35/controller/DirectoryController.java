package tech.itpark.itpark2021.lesson35.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.itpark.itpark2021.lesson35.dto.DirectoryPageDto;
import tech.itpark.itpark2021.lesson35.service.DirectoryService;

@Controller
@RequiredArgsConstructor
public class DirectoryController {

    private final DirectoryService service;


    @GetMapping("/directory")
    public String getDirectoryPage(Model model,
                                   @RequestParam(required = false, defaultValue = "0") Integer page,
                                   @RequestParam(required = false, defaultValue = "5") Integer size) {
        DirectoryPageDto allDirectories = service.getPage(PageRequest.of(page, size));
        model.addAttribute("directories", allDirectories);
        return "directory/directoryOfRegions";
    }

}
