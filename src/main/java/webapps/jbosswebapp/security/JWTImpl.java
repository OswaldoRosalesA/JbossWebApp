package webapps.jbosswebapp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import javax.ws.rs.core.Response;

/**
 *
 * @author oswaldo
 */
public class JWTImpl {

    public static String generateJWT(String login, String path) {
        final String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(path)
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusSeconds(5L)))
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode("SigningKey".getBytes()))
                .compact();
        return jwtToken;
    }

    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Response generateAuthenticatedResponse(Object entity, Response.Status status, String issuer, String subject) {
        return Response.status(status)
                .header("Authorization", "Bearer " + generateJWT(subject, issuer))
                .entity(entity)
                .encoding("UTF-8")
                .build();
    }

    public static Response generateUnAuthenticatedResponse(Object entity, Response.Status status) {
        return Response.status(status)
                .entity(entity)
                .encoding("UTF-8")
                .build();
    }

}
