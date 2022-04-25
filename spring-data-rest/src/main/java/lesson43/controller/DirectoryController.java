package lesson43.controller;


import lesson43.model.Directory;
import lesson43.repository.DirectoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class DirectoryController {

    private final DirectoryRepository repository;

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
        model.addAttribute("directory", repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Non existed directory")));
        return "directory/directoryCreateAndUpdate";
    }

    @PostMapping("/directory/save")
    public String addNewDirectory(@Valid Directory directory) {
        repository.save(directory);
        return "redirect:/directories";
    }
}
