package hello.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserDto {

    private Integer userId;
    @NotNull(message = "login can't be empty")
    private String userName;
    @NotNull(message = "password can't be empty")
    private String password;
    private String email;
    private int enabled;
    private List<String> userRoles;

}
