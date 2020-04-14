package io.codecooker.hidayet.friends.payload.response;

import io.codecooker.hidayet.friends.payload.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUsersResponse {
    private List<UserDTO> users;
}
