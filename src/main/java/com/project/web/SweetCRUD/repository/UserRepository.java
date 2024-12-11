package com.project.web.SweetCRUD.repository;

import com.project.web.SweetCRUD.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByEmailAndPassword(String email, String password);
    Optional<Users> findByEmail(String email);
}
