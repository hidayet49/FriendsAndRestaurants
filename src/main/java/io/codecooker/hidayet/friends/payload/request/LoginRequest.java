package io.codecooker.hidayet.friends.payload.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Validated
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    @Length(min=6)
    private String password;
}
