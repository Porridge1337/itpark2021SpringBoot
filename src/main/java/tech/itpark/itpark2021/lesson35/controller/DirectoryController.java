package tech.itpark.itpark2021.lesson35.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.itpark.itpark2021.lesson35.dto.DirectoryDto;
import tech.itpark.itpark2021.lesson35.dto.DirectoryPageDto;
import tech.itpark.itpark2021.lesson35.service.DirectoryService;
import tech.itpark.itpark2021.lesson35.validator.PositivOrZero;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Controller
@Validated
@RequiredArgsConstructor
public class DirectoryController {

    private final DirectoryService service;


    @GetMapping("/directory")
    public String getDirectoryPage(Model model,
                                   @PositivOrZero @RequestParam(required = false, defaultValue = "0") Integer page,
                                   @Positive @RequestParam(required = false, defaultValue = "5") Integer size) {
        DirectoryPageDto allDirectories = service.getPage(PageRequest.of(page, size));
        model.addAttribute("directories", allDirectories);
        return "directory/directoryOfRegions";
    }

    @GetMapping("/directory/add")
    public String getDirectoryPageCreate() {
        return "directory/directoryCreateAndUpdate";
    }

    @GetMapping("/directory/update")
    public String getDirectoryPageUpdate(@RequestParam(name = "id") Long regionId, Model model) {
        DirectoryDto currentDirectory = service.getById(regionId).
                orElseThrow(() -> new IllegalArgumentException("Non existed directory"));
        model.addAttribute("directory", currentDirectory);
        return "directory/directoryCreateAndUpdate";
    }

    @PostMapping("/directory/save")
    public String addNewDirectory(@Valid DirectoryDto directory) {
        service.save(directory);
        return "redirect:/directory";
    }


}
