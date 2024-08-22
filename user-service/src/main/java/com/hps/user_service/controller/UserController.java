package com.hps.user_service.controller;

import com.hps.user_service.dto.UserRequest;
import com.hps.user_service.dto.UserResponse;
import com.hps.user_service.entity.User;
import com.hps.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController  {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody UserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }
    @PutMapping
    public ResponseEntity<Void> updateUser (@RequestBody UserRequest request){
         userService.updateUser(request);
         return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/exists/{userId}")
    public ResponseEntity<Boolean> isExistById(
            @PathVariable("userId") Long userId
    ){
        return ResponseEntity.ok( userService.existById(userId));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findById(
            @PathVariable("userId") Long userId
    ){
        return ResponseEntity.ok( userService.findById(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(
            @PathVariable("userId") Long userId
    ) {
        userService.deleteUser(userId);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/phone/{phone}")
    public ResponseEntity<User> findByPhone(
            @PathVariable("phone") String phone
    ){
        return ResponseEntity.ok( userService.findUserByPhone(phone));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<User> findByEmail(
            @PathVariable("email") String email
    ){
        return ResponseEntity.ok( userService.findUserByEMail(email));
    }


}
