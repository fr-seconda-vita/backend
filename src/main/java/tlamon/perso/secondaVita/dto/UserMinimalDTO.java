package tlamon.perso.secondaVita.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tlamon.perso.secondaVita.models.user.Roles;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMinimalDTO {
    private int id;
    private String mail;
    private String lastName;
    private String firstName;
    private Roles role;
}
