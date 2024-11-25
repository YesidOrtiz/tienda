package com.tienda.webConfigSecurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private static String SECRET_KEY="tiendaAplicacion2024";
    private static Algorithm ALGORITHM=Algorithm.HMAC256(SECRET_KEY);

    public String create(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("aplicacion_tienda")//quien firma
                .withIssuedAt(new Date())//cuando se firmo el token
                .withExpiresAt(new Date(System.currentTimeMillis()+ TimeUnit.DAYS.toMillis(15)))//fecha en la que se vence
                .sign(ALGORITHM);//firmado con este algoritmo
    }
}
