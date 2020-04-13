package io.codecooker.hidayet.friends.model.DTO;

import io.codecooker.hidayet.friends.model.DAO.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String Email;
    private Set<Role> roles;
    private boolean isEnabled;

}
