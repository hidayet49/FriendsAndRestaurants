package io.codecooker.hidayet.friends.service;

import io.codecooker.hidayet.friends.model.DTO.UserDTO;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Set;

public interface UserService {
    void changeUserRole(Long userId, Set<String> strRoles);
    List<UserDTO> getAllUsers();
    void changeColor(Long id, String color);
    void enableUser(Long id);
    void disableUser(Long id);
    void updateLocation(Double latitude, Double longitude, Long id);


}
