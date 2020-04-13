package io.codecooker.hidayet.friends.payload.response;

import io.codecooker.hidayet.friends.model.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetInfoResponse {
    private UserDTO user;
}
