package tech.itpark.itpark2021.lesson38.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech.itpark.itpark2021.lesson38.model.User;
import tech.itpark.itpark2021.lesson38.model.type.Status;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@ToString
public class UserPrincipal implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Authorities.ROLE_PREFIX + user.getRole().getName()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !Status.LOGIN_EXPIRED.equals(user.getStatus());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !Status.BLOCKED.equals(user.getStatus());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !Status.PASSWORD_EXPIRED.equals(user.getStatus());
    }

    @Override
    public boolean isEnabled() {
        return Status.OK.equals(user.getStatus());
    }
}
