package com.unibank.service.impl;

import com.unibank.dto.UserDTO;
import com.unibank.entity.User;
import com.unibank.exception.UserNotFoundException;
import com.unibank.mapper.UserMapper;
import com.unibank.repository.UserRepository;
import com.unibank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User save (User user){
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDTOList((List<User>) userRepository.findAll());
    }

    @Override
    public UserDTO findById(String id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id)));
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
