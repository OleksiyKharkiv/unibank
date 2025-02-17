package com.unibank.controller;

import com.unibank.dto.UserDTO;
import com.unibank.entity.User;
import com.unibank.exception.UserNotFoundException;
import com.unibank.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Controller", description = "User")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Save user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser = userService.save(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = " Get all users")
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get user by id")
    public UserDTO getUserById(@PathVariable String id) {
        UserDTO userDTO = userService.findById(id);
        if (userDTO != null) {
            return userDTO;
        } else {
            throw new UserNotFoundException("User with id " + id + "not found");
        }
    }

    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
