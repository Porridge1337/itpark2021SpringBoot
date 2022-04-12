package tech.itpark.itpark2021.lesson38.Controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.itpark.itpark2021.lesson38.security.jwt.JwtHelper;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final JwtHelper jwtHelper;
    private String token;

    @PostMapping("/jwt")
    public String jwt(@RequestParam String login, @RequestParam String right) {
        token = jwtHelper.generateToken("me", login, new String[]{right});
        return token;
    }

    @GetMapping("/secured/jwt")
    public String securedJwt() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof PreAuthenticatedAuthenticationToken authorizedUser) {
            System.out.println(authorizedUser.getPrincipal().toString());
            return authorizedUser.getPrincipal().toString();
        }
        return "NoUser";
    }

}
