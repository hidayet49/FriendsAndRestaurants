package io.codecooker.hidayet.friends.controllers;

import io.codecooker.hidayet.friends.payload.request.ChangeRoleRequest;
import io.codecooker.hidayet.friends.payload.response.GetUsersResponse;
import io.codecooker.hidayet.friends.payload.response.MessageResponse;
import io.codecooker.hidayet.friends.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
public class AdminImp implements Admin{
    @Autowired
    private UserServiceImp userService;

    @Override
    @PostMapping("/changeRole")
    public ResponseEntity<MessageResponse> changeRole(@RequestBody ChangeRoleRequest req){
        userService.changeUserRole(req.getUserId(),req.getRoles());
        return ResponseEntity.ok(new MessageResponse("The roles updated successfully"));
    }

    @Override
    @GetMapping ("/getusers")
    public  ResponseEntity<GetUsersResponse> getAllUsers() {
        GetUsersResponse responseBody=new GetUsersResponse();
        responseBody.setUsers(userService.getAllUsers());
        return ResponseEntity.ok(responseBody);
    }

    @Override
    @GetMapping ("/findusers")
    public ResponseEntity<GetUsersResponse> findUser(@RequestParam(value = "key",required = true) String key) {
        return null;
    }

    @Override
    @PostMapping ("/disableuser")
    public ResponseEntity<MessageResponse> disableUser(Long id) {


        return null;
    }

    @Override
    @PostMapping ("/enableuser")
    public ResponseEntity<MessageResponse> enableUser(Long id) {
        return null;
    }


}
