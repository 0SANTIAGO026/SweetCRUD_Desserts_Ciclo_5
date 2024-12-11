package com.project.web.SweetCRUD.service.impl;

import com.project.web.SweetCRUD.dto.UserAuthDto;
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
}
