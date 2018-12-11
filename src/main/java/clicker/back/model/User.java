package clicker.back.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private String uid;
    private String displayName;
    private String email;
    private Integer mark;
    private Role role;

    public enum Role {
        ADMIN, USER
    }
}


