package pt.web.al2022.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pt.web.al2022.model.Role;
import pt.web.al2022.model.User;
import pt.web.al2022.utils.SecurityUtils;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomUser implements UserDetails {

    private Long id;
    private String username;
    transient private String password; //Don't show up on serialized places
    transient private User user; //user for only login operation
    private Set<GrantedAuthority> authorities;

    public static CustomUser createSuperUser() {

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));

        return CustomUser.builder()
                .id(-1L)
                .username("system-admin")
                .authorities(authorities)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
