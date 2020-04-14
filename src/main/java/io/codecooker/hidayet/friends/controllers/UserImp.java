package io.codecooker.hidayet.friends.controllers;

import io.codecooker.hidayet.friends.payload.dto.UserDTO;
import io.codecooker.hidayet.friends.payload.request.ChangeColorRequest;
import io.codecooker.hidayet.friends.payload.response.GetInfoResponse;
import io.codecooker.hidayet.friends.payload.response.MessageResponse;
import io.codecooker.hidayet.friends.security.services.UserDetailsImpl;
import io.codecooker.hidayet.friends.service.UserServiceImp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authusers")
public class UserImp implements User {
    @Autowired
    private UserServiceImp userService;

    @Override
    @GetMapping("/getmyinfo")
    public ResponseEntity<GetInfoResponse> getUserInfo(Authentication auth) {

        UserDTO userDTO= new UserDTO();
        BeanUtils.copyProperties(auth.getPrincipal(),userDTO);
        GetInfoResponse getInfoResponse = new GetInfoResponse(userDTO);
        return ResponseEntity.ok(getInfoResponse);
    }

    @Override
    @PostMapping("/changemycolor")
    public ResponseEntity changeMyColor(@RequestBody ChangeColorRequest req, Authentication auth) {
        userService.changeColor(((UserDetailsImpl)auth.getPrincipal()).getId(), req.getColor());
        return ResponseEntity.ok(new MessageResponse("Your color is updated successfully!!"));
    }

    @Override
    public void setLocation(Double latitude, Double longitude) {

    }
}
