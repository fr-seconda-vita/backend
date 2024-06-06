package tlamon.perso.secondaVita.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tlamon.perso.secondaVita.models.user.Roles;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private Roles role;
}
