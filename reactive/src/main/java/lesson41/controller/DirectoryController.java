package lesson41.controller;

import lesson41.dto.DirectoryDto;
import lesson41.mapper.DirectoryMapper;
import lesson41.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class DirectoryController {

    private final DirectoryService directoryService;
    private final DirectoryMapper mapper;

    @GetMapping("/directory")
    public String getAllRepository(Model model) {
        model.addAttribute("directories", directoryService.findAll());
        return "dir/directories";
    }

    @GetMapping("/directory/add")
    public String getDirectoryPageCreate() {
        return "dir/dirCreateAndUpdate";
    }

    @PostMapping("/directory/save")
    public String addNewDirectory(@Valid DirectoryDto directory) {
        directoryService.save(mapper.toEntity(directory));
        return "redirect:/directory";
    }

}
