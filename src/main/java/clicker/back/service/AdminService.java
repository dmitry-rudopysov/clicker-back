package clicker.back.service;

import clicker.back.model.User;
import clicker.back.repository.AwardRepository;
import clicker.back.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@Log4j2
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminService {

    @NonNull
    private final AwardRepository awardRepository;

    @NonNull
    private final UserRepository userRepository;

    public void flushResults(String uid) {
        if (testAdmin(uid)) {
            awardRepository.deleteAll();
        }
    }

    public void updateUser(String uid, User user) {
        if (testAdmin(uid)) {
            userRepository.save(user);
        }
    }

    public List<User> getAllUsers(String uid) {
        if (testAdmin(uid)) {
            return userRepository.findAll();
        }
        return new ArrayList<>();
    }

    private boolean testAdmin(String uid) {
        User testAdmin = userRepository.findUserByUid(uid);
        return testAdmin.getRole() == User.Role.ADMIN;
    }

    public User.Role getRole(String uid) {
        return userRepository.findUserByUid(uid).getRole();
    }
}
