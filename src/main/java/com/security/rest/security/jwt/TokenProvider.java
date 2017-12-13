package com.security.rest.security.jwt;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenProvider {

    private static final String AUTHORITIES_KEY = "auth";

    private String secretKey = "mySecretKey";

    public Authentication getAuthentication(String jwtToken) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwtToken)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, jwtToken, authorities);
    }

    public String createToken(Authentication authentication, Boolean rememberMe) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity;
        if (rememberMe) {
            validity = new Date(now + (1000 * 5000));
        } else {
            validity = new Date(now + (1000 * 5000));
        }

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setExpiration(validity)
                .compact();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature.");
            System.out.println("Invalid JWT signature trace: {}" + e);
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token.");
            System.out.println("Invalid JWT token trace: {}"+ e);
        } catch (ExpiredJwtException e) {
            System.out.println("Expired JWT token.");
            System.out.println("Expired JWT token trace: {}"+ e);
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT token.");
            System.out.println("Unsupported JWT token trace: {}"+ e);
        } catch (IllegalArgumentException e) {
            System.out.println("JWT token compact of handler are invalid.");
            System.out.println("JWT token compact of handler are invalid trace: {}"+ e);
        }
        return false;
    }
}
