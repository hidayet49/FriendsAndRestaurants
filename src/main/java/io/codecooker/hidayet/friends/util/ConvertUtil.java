package io.codecooker.hidayet.friends.util;

import io.codecooker.hidayet.friends.model.entity.Role;
import io.codecooker.hidayet.friends.model.entity.User;
import io.codecooker.hidayet.friends.payload.dto.UserDTO;

import java.util.Collection;

public interface ConvertUtil {
    UserDTO userDAOtoDTO(User userDAO);
    Collection<UserDTO> userDAOCollectionToDTOCollection(Collection<User> users);
    Collection<Role> stringRolesToRole(Collection<String> strRoles);


}
