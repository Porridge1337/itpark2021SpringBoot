package lesson43.controller;


import lesson43.model.Directory;
import lesson43.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Validated
@RequiredArgsConstructor
public class DirectoryController {

    private final DirectoryService directoryService;

    @GetMapping("/directories")
    public String getDirectories() {
        return "directory/directoryOfRegions";
    }

    @GetMapping("/directory/add")
    public String getDirectoryPageCreate() {
        return "directory/directoryCreateAndUpdate";
    }

    @GetMapping("/directory/update")
    public String getDirectory(@RequestParam Long id, Model model) {
        model.addAttribute("directory", directoryService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Non existed directory")));
        return "directory/directoryCreateAndUpdate";
    }

    @PostMapping("/directory/save")
    public String addNewDirectory(@Valid Directory directory) {
        directoryService.save(directory);
        return "redirect:/directories";
    }
}
