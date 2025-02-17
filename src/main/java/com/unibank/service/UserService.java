package com.unibank.service;

import com.unibank.dto.UserDTO;
import com.unibank.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<UserDTO> findAll();

    UserDTO findById(String id);

    void deleteUser(String id);
}
