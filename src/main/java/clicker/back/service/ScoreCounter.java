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

        long griffindorScore = getTeamScore("griffindor");
        long slytherinScore = getTeamScore("slytherin");
        long hufflepuffScore = getTeamScore("hufflepuff");
        long ravenclawScore = getTeamScore("ravenclaw");

        GameScore gameScore = new GameScore();
        gameScore.addTeam(new Team("griffindor", griffindorScore));
        gameScore.addTeam(new Team("slytherin", slytherinScore));
        gameScore.addTeam(new Team("hufflepuff", hufflepuffScore));
        gameScore.addTeam(new Team("ravenclaw", ravenclawScore));

        return gameScore;
    }

    private long getTeamScore(String teamName) {
        List<Award> all = awardRepository.findAll();
        return all.stream()
                //TODO :: add judge auth filter?
                .filter(award -> teamName.equals(award.getTeamName()))
                .map(Award::getAddScore)
                .reduce((a1, a2)-> a1 + a2)
                .orElse(0);
    }
}
