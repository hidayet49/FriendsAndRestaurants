package io.codecooker.hidayet.friends.service;

import io.codecooker.hidayet.friends.model.DAO.Location;
import io.codecooker.hidayet.friends.model.DTO.UserDTO;
import io.codecooker.hidayet.friends.model.EColor;
import io.codecooker.hidayet.friends.model.ERole;
import io.codecooker.hidayet.friends.model.DAO.Role;
import io.codecooker.hidayet.friends.model.DAO.User;
import io.codecooker.hidayet.friends.repository.LocationRepository;
import io.codecooker.hidayet.friends.repository.RoleRepository;
import io.codecooker.hidayet.friends.repository.UserRepository;
import io.codecooker.hidayet.friends.util.ConvertUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  LocationRepository locationRepository;


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ConvertUtilImpl convert;

    @Override
    public void changeUserRole(Long userId, Set<String> strRoles) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user cannot be found"));

        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    @Retryable
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return null;
        }
        List<UserDTO> userDTOS = (List) convert.userDAOCollectionToDTOCollection(users);
        return userDTOS;
    }

    @Override
    @Retryable
    public void changeColor(Long id, String color) {
        Optional<User> userOptional=userRepository.findById(id) ;
        User user=userOptional.orElseThrow(()->new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"There is an error occured. Please try again"));
        try {
            user.setColor(Enum.valueOf(EColor.class, color));
        } catch (IllegalArgumentException e) {
            user.setColor(EColor.NAVY);
            e.printStackTrace();
        } catch (Exception e) {
            user.setColor(EColor.NAVY);
            e.printStackTrace();
        }
        userRepository.save(user);
    }

    @Override
    @Transactional
    @Retryable
    public void updateLocation(Double latitude, Double longitude, Long id) {
        Optional<User> userOptional=userRepository.findById(id) ;
        User user=userOptional.orElseThrow(()->new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"There is an error occured. Please try again"));
        Location location=locationRepository.save(new Location(longitude,latitude));
        user.setLocation(location);
        userRepository.save(user);
    }
    @Retryable
    @Override
    public void enableUser(Long id) {
        Optional<User> userOptional=userRepository.findById(id) ;
        User user=userOptional.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No user Found with this ID!!"));
        user.setEnabled(true);
    }

    @Retryable
    @Override
    public void disableUser(Long id) {
        Optional<User> userOptional=userRepository.findById(id) ;
        User user=userOptional.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No user Found with this ID!!"));
        user.setEnabled(false);
    }
}
