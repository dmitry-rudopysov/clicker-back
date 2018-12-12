package clicker.back.controller;

import clicker.back.model.User;
import clicker.back.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@AllArgsConstructor(onConstructor=@__(@Autowired))
@RequestMapping("admin")
public class AdminController {

    @NonNull
    private final AdminService adminService;


    @GetMapping("flushResults")
    public ResponseEntity flushResults(@RequestParam String uid) {
        adminService.flushResults(uid);
        return ResponseEntity.ok().build();
    }


    @PostMapping("updateUser")
    public ResponseEntity updateUser(@RequestParam String uid, @RequestBody User user) {
        adminService.updateUser(uid, user);
        return ResponseEntity.ok().build();
    }


    @GetMapping("getAllUsers")
    public List<User> updateUser(@RequestParam String uid) {
        return adminService.getAllUsers(uid);
    }


    @GetMapping("getRole")
    public User.Role getRole(@RequestParam String uid) {
        return adminService.getRole(uid);
    }
}
