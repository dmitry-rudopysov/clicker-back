package clicker.back.controller;

import clicker.back.model.Award;
import clicker.back.repository.AwardRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Log4j2
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class AwardController {

    @NonNull
    private AwardRepository awardRepository;

    @CrossOrigin(origins = "http://localhost:8089")
    @PostMapping("/addAward")
    public ResponseEntity greeting(@RequestBody Award award) {

        award.setDateTime(LocalDateTime.now());
        Award save = awardRepository.save(award);

        log.trace(save);

        return ResponseEntity.ok().build();
    }
}
