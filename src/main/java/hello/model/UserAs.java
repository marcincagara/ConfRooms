package hello.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class UserAs { //dlaczego z samym User program sie wywala

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;
    private String password;

    public UserAs() {
    }

    public UserAs(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
