package clicker.back.controller;

import clicker.back.model.Award;
import clicker.back.service.AwardService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class AwardController {

    @NonNull
    private AwardService awardService;


    @PostMapping("/addAward")
    public ResponseEntity greeting(@RequestBody Award award) {

        awardService.saveAward(award);

        return ResponseEntity.ok().build();
    }
}
