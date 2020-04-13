package io.codecooker.hidayet.friends.controllers;


import io.codecooker.hidayet.friends.payload.request.ChangeColorRequest;
import io.codecooker.hidayet.friends.payload.response.GetInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface User{
    ResponseEntity getUserInfo(Authentication auth);
    ResponseEntity changeMyColor(ChangeColorRequest req, Authentication auth);
    void setLocation(Double latitude,Double longitude);

}
