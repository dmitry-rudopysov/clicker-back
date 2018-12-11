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

@Service
@Getter
@Setter
@Log4j2
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class UserService {

    @NonNull
    private final UserRepository userRepository;

    public Integer getMark(String uid) {
        User user = userRepository.findUserByUid(uid);
        return user!=null ? user.getMark() : 0;
    }

    public void registerUser(User user) {
        User userFromDb = userRepository.findUserByUid(user.getUid());

        if (userFromDb==null) {
            user.setMark(0);
            user.setRole(User.Role.USER);
            userRepository.save(user);
        }
    }
}
