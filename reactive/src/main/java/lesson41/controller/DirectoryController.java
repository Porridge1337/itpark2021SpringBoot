package lesson41.controller;

import lesson41.dto.DirectoryDto;
import lesson41.mapper.DirectoryMapper;
import lesson41.model.Directory;
import lesson41.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Validated
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

    @GetMapping("/directory/update")
    public String getDirectoryUpdate(@RequestParam(name = "id") String regionId, Model model) {
        Mono<Directory> currentDirectory = directoryService.findByRegionId(regionId);
        model.addAttribute("directory", currentDirectory);
        return "dir/dirCreateAndUpdate";
    }

    @PostMapping("/directory/save")
    public String addNewDirectory(@Valid Directory directory) {
        directoryService.save(directory);
        return "redirect:/directory";
    }
}
