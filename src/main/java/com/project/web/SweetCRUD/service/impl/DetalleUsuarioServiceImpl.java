package com.project.web.SweetCRUD.service.impl;

import com.project.web.SweetCRUD.entity.Users;
import com.project.web.SweetCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalleUsuarioServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> optional = userRepository.findByEmail(email);
        if(optional.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        Users user = optional.get();
        UserBuilder userBuilder = User.withUsername(user.getEmail());
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getProfile().getProfileName());

        return userBuilder.build();
    }
}
