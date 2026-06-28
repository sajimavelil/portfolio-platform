package com.sajijoseph.portfolio.auth.jwt;

import com.sajijoseph.portfolio.auth.config.SecurityProperties;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import io.jsonwebtoken.Claims;

@Service
public class JwtService {

    private final SecurityProperties securityProperties;

    public JwtService(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                securityProperties
                        .getJwtSecret()
                        .getBytes(StandardCharsets.UTF_8)
        );

    }

    public String generateAccessToken(String email) {

        Date now = new Date();

        Date expiry = new Date(
                now.getTime() +
                        securityProperties.getJwtExpiration()
        );

        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(getSigningKey())
                .compact();

    }

    public String extractUsername(String token) {

        return extractClaims(token).getSubject();

    }

    private Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    public boolean isTokenValid(String token, String email) {

        return email.equals(extractUsername(token))
                && !extractClaims(token)
                .getExpiration()
                .before(new Date());

    }


}