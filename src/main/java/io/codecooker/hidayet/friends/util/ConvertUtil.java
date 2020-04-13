package io.codecooker.hidayet.friends.util;

import io.codecooker.hidayet.friends.model.DAO.Role;
import io.codecooker.hidayet.friends.model.DAO.User;
import io.codecooker.hidayet.friends.model.DTO.UserDTO;

import java.util.Collection;

public interface ConvertUtil {
    UserDTO userDAOtoDTO(User userDAO);
    Collection<UserDTO> userDAOCollectionToDTOCollection(Collection<User> users);
    Collection<Role> stringRolesToRole(Collection<String> strRoles);


}
