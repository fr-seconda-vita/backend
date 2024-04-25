package tlamon.perso.secondaVita.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // permet de dire à Spring que cette classe est un composant
@RequiredArgsConstructor // permet de générer un constructeur avec les propriétés final
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService; // injecte le service JwtService

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request, // récupère la requête
            @NonNull HttpServletResponse response, // récupère la réponse
            @NonNull FilterChain filterChain // permet de passer la requête à la suite du traitement
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization"); // récupère le header Authorization
        final String jwt;
        final String userName;

        // si le header Authorization est null ou ne commence pas par "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // on passe à la suite du traitement
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7); // on récupère le token JWT sans le "Bearer "
        userName = jwtService.extractUserName(jwt);
    }
}
