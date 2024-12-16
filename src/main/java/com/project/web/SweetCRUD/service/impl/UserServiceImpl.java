package com.project.web.SweetCRUD.service.impl;

import com.project.web.SweetCRUD.dto.UserAuthDto;
import com.project.web.SweetCRUD.entity.Profiles;
import com.project.web.SweetCRUD.entity.Users;
import com.project.web.SweetCRUD.repository.UserRepository;
import com.project.web.SweetCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).isPresent();
    }

    @Override
    public Boolean registerUser(UserAuthDto userAuthDto) {
        if(userRepository.findByEmail(userAuthDto.email()).isPresent())
            return false;
        else {
            Users user = new Users();
            user.setEmail(userAuthDto.email());
            user.setPassword(userAuthDto.password1());
            Profiles profiles = new Profiles();
            profiles.setIdProfile(2);
            user.setProfile(profiles);
            userRepository.save(user);
            return true;
        }
    }
}
