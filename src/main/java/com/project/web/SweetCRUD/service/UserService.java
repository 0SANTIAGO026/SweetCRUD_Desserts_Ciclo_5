package com.project.web.SweetCRUD.service;

import com.project.web.SweetCRUD.dto.UserAuthDto;

public interface UserService {
    Boolean findByEmailAndPassword(String email, String password);
}
