package tech.itpark.itpark2021.lesson35.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.itpark.itpark2021.lesson35.dto.UserDto;
import tech.itpark.itpark2021.lesson35.service.UserService;

import javax.validation.Valid;

@Controller
@Validated
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/regPage")
    public String getRegistrationPage() {
        return "registration/registrationPage";
    }

    @PostMapping("/registration")
    public String createUser(@Valid UserDto userDto) {
        userService.save(userDto);

        return "redirect:/login";
    }

}
