package tech.itpark.itpark2021.lesson38.security.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;
import tech.itpark.itpark2021.lesson38.security.dto.AuthorizedUser;
import tech.itpark.itpark2021.lesson38.security.jwt.JwtHelper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtHelper jwtHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final Optional<String> token = getTokenIfPresent(request);
        if (token.isPresent()) {
            final AuthorizedUser authorizedUser = jwtHelper.parseToken(token.get());
            if (authorizedUser != null) {
                Authentication authenticationToken = authUserByToken(authorizedUser);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    public Optional<String> getTokenIfPresent(HttpServletRequest request) { //проверка: есть ли токен в заголовке
        return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(authHeader -> authHeader.contains("Bearer"))
                .map(authHeader -> authHeader.split("Bearer ")[1]);
    }

    private AbstractAuthenticationToken authUserByToken(AuthorizedUser authorizedUser) {
        return new PreAuthenticatedAuthenticationToken(authorizedUser, "-",
                AuthorityUtils.createAuthorityList(authorizedUser.getRights()));
    }
}
