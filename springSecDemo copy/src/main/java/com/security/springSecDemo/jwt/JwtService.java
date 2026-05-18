package com.security.springSecDemo.jwt;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {



    private static final String SECRET =
            Dotenv.load().get("JWT_SECRET");

    private final SecretKey KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    // GENERATE TOKEN
    public String generateToken(String username) {

        return Jwts.builder()

                .subject(username)

                .issuedAt(new Date())

                .expiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 10)
                )

                .signWith(KEY)

                .compact();
    }

    // EXTRACT USERNAME
    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    // EXTRACT EXPIRATION
    public Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);
    }

    // GENERIC CLAIM EXTRACTOR
    public <T> T extractClaim(String token,
                              Function<Claims, T> resolver) {

        Claims claims = extractAllClaims(token);

        return resolver.apply(claims);
    }

    // EXTRACT ALL CLAIMS
    private Claims extractAllClaims(String token) {

        return Jwts.parser()

                .verifyWith(KEY)

                .build()

                .parseSignedClaims(token)

                .getPayload();
    }

    // CHECK TOKEN EXPIRY
    private boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    // VALIDATE TOKEN
    public boolean isTokenValid(String token,
                                String username) {

        final String extractedUsername =
                extractUsername(token);

        return extractedUsername.equals(username)
                &&
                !isTokenExpired(token);
    }
}