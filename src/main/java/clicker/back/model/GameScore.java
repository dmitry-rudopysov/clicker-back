package clicker.back.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class GameScore {

    private List<Team> teams;

    public void addTeam(Team team) {
        if (teams == null) {
            teams = new ArrayList<>();
        }

        teams.add(team);
    }
}
