package io.codecooker.hidayet.friends.controllers;

import io.codecooker.hidayet.friends.payload.request.ChangeRoleRequest;
import io.codecooker.hidayet.friends.payload.response.GetUsersResponse;
import io.codecooker.hidayet.friends.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;

public interface Admin {
    // Change the role of the user
    ResponseEntity<MessageResponse> changeRole( ChangeRoleRequest req);
    // Get all users in DB
    ResponseEntity<GetUsersResponse> getAllUsers();
    // Find user with keywords
    ResponseEntity<GetUsersResponse> findUser(String key);
    // Disable the user
    ResponseEntity<MessageResponse> disableUser(Long id);
    // Enable the user
    ResponseEntity<MessageResponse> enableUser(Long id);




}
