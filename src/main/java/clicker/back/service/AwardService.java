package clicker.back.service;

import clicker.back.model.Award;
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

import java.time.LocalDateTime;

@Service
@Getter
@Setter
@Log4j2
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AwardService {

    @NonNull
    private final AwardRepository awardRepository;

    @NonNull
    private final UserRepository userRepository;

    public void saveAward(Award award) {
        User user = userRepository.findUserByUid(award.getUserId());

        award.setDateTime(LocalDateTime.now());
        award.setAddScore(user.getMark());

        awardRepository.save(award);
    }
}
