package io.codecooker.hidayet.friends.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ChangeRoleRequest {
    private Long userId;
    private Set<String> roles;

}
