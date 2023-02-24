package rw.jazzyBruno.todo.v1.serviceImpls;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
    private String jwtSecretKey = "secret@OK";

    public String extractUsername(String token){
          return extractClaim(token , Claims::getSubject);
    }


}
