package hello.dto;

import hello.model.UserRole;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserDto {

    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private int enabled;
    private List<String> userRoles;

}
