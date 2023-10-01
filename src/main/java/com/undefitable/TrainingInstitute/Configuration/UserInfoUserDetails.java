package com.undefitable.TrainingInstitute.Configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.undefitable.TrainingInstitute.Entities.User;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


public class UserInfoUserDetails implements UserDetails {


	private String username;
    private String password;
    private Set<SimpleGrantedAuthority> authorities;

    public UserInfoUserDetails(User user) {
        username=user.getUsername();
        password=user.getPassword();
        
//        authorities= Arrays.stream(user.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
       
       
         authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        });
       
       
        
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
