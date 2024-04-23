package tlamon.perso.secondaVita.model.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "mail", nullable = false, unique = true, length = 100)
    private String mail;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "address_number", length = 10)
    private String addressNumber;

    @Column(name = "address_name", nullable = false, length = 100)
    private String addressName;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 50)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    // défini la paire nom/prénom comme username
    @Override
    public String getUsername() {
        return lastName+" "+firstName;
    }

    //affirme que le compte n'a pas expiré
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //affirme que le compte n'est pas bloqué
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //affirme que le mot de passe n'a pas expiré
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //affirme que le compte est activé
    @Override
    public boolean isEnabled() {
        return true;
    }
}
