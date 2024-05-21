package ru.alx.trackview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.alx.trackview.dao.AppUserDAO;
import ru.alx.trackview.model.AppUser;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final AppUserDAO appUserDAO;

    public UserDetailsServiceImpl(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser currentuser = appUserDAO.findByName(username);

        User.UserBuilder builder = null;
        if (currentuser != null) {
            builder = User.withUsername(username);
            builder.password(currentuser.getPassword());
            builder.roles(currentuser.getRole());
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return builder.build();
    }
}
