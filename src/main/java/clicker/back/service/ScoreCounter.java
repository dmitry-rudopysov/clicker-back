package clicker.back.service;

import clicker.back.model.Award;
import clicker.back.model.GameScore;
import clicker.back.model.Team;
import clicker.back.repository.AwardRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Getter @Setter @Log4j2
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ScoreCounter {

    @NonNull
    private final AwardRepository awardRepository;

    public GameScore getGameScore() {
        //todo implement score count
        List<Award> all = awardRepository.findAll();


        LocalDateTime now = LocalDateTime.now();

        Award award = new Award();
        award.setDateTime(now);
        award.setAddScore(10);
        Award save = awardRepository.save(award);

        Award byDateTimeEqualsAndAddScore = awardRepository.findByDateTimeEqualsAndAddScore(now, 10);


        log.trace(byDateTimeEqualsAndAddScore);

        //Mock now
        GameScore gameScore = new GameScore();
        gameScore.addTeam(new Team("Team1", (int) (Math.random()*100)));
        gameScore.addTeam(new Team("Team2", (int) (Math.random()*100)));
        gameScore.addTeam(new Team("Team3", (int) (Math.random()*100)));

        return gameScore;
    }
}
