package clicker.back.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Team {

    @Id
    private String name;
    private Long score;
}
