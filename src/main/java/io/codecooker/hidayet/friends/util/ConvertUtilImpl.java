package io.codecooker.hidayet.friends.util;

import io.codecooker.hidayet.friends.model.DAO.Role;
import io.codecooker.hidayet.friends.model.DAO.User;
import io.codecooker.hidayet.friends.model.DTO.UserDTO;
import io.codecooker.hidayet.friends.model.ERole;
import io.codecooker.hidayet.friends.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConvertUtilImpl implements ConvertUtil{
    @Autowired
    private RoleRepository roleRepository;

    public UserDTO userDAOtoDTO(User userDAO){
        UserDTO userDTO= new UserDTO();
        BeanUtils.copyProperties(userDAO,userDTO);
        return userDTO;
    }

    @Override
    public Collection<UserDTO> userDAOCollectionToDTOCollection(Collection<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(item->{
            UserDTO userDTO =new UserDTO();
            BeanUtils.copyProperties(item,userDTO);
            userDTOS.add(userDTO);

        });
        return userDTOS;
    }

    public Collection<Role> stringRolesToRole(Collection<String> strRoles){

        Set<Role> roles = new HashSet<>();
        if (strRoles == null || strRoles.isEmpty()) {
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
        return roles;
    }
}
