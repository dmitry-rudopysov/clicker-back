package clicker.back.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter @Setter
public class Award {

    @Id
    private String id;
    private LocalDateTime dateTime;
    private String userId;
    private String teamName;
    private Integer addScore;
}
