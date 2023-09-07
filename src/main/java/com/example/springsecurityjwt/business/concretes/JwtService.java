package com.example.springsecurityjwt.business.concretes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JwtService {


    private String SECTRET_KEY = "DWygajkakvKtvT6SxFduSLiPo7PnqGq5i2lb2DBqimEcuQVttOlH7B21wi1cT6se";
    public String findUsername(String jwt){

        return exportToken(jwt,Claims::getSubject);
    }

    private <T> T exportToken(String jwt, Function<Claims,T> claimsTFunction){
        final Claims claims = Jwts.parserBuilder().setSigningKey(getKey()).build()
                .parseClaimsJws(jwt).getBody();

        return claimsTFunction.apply(claims);
    }

    private Key getKey(){
        byte[] key = Decoders.BASE64.decode(SECTRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }

    public boolean tokenControl(String jwt, UserDetails userDetails) {
        final String username = findUsername(jwt);
        return (username.equals(userDetails.getUsername()) && !exportToken(jwt, Claims::getExpiration).before(new Date()));
    }

    public String generateToken(UserDetails user){

        return Jwts.builder().setClaims(new HashMap<>())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
