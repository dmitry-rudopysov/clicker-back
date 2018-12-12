package clicker.back.controller;

import clicker.back.model.GameScore;
import clicker.back.service.ScoreCounter;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ResultController {

    @NonNull
    private final ScoreCounter scoreCounter;


    @GetMapping("/getScore")
    public GameScore getScore() {
        return scoreCounter.getGameScore();
    }
}
