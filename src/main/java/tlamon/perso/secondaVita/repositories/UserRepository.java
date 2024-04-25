package tlamon.perso.secondaVita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tlamon.perso.secondaVita.models.user.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    // This method is used to find a user by its mail
    Optional<Users> findByMail(String mail);
}
