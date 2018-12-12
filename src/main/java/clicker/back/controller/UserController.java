package clicker.back.controller;

import clicker.back.model.User;
import clicker.back.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class UserController {

    @NonNull
    private final UserService userService;


    @GetMapping("getUserMark")
    public Integer getUserMark(@RequestParam String uid) {
        return userService.getMark(uid);
    }


    @PostMapping("registerUser")
    public ResponseEntity registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok().build();
    }
}
