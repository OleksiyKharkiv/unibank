package com.unibank.mapper;

import com.unibank.dto.UserDTO;
import com.unibank.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    UserDTO toDTO (User user);
    List<UserDTO> toDTOList (List<User> users);
}
