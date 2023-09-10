package info.subashghimire.user.management.service;

import info.subashghimire.user.management.dto.UserDto;
import info.subashghimire.user.management.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
