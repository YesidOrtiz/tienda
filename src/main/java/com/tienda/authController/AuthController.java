package com.tienda.authController;

import com.tienda.authController.model.LoginDTO;
import com.tienda.webConfigSecurity.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDTO dto){
        UsernamePasswordAuthenticationToken login=new UsernamePasswordAuthenticationToken(dto.getDocumento(),dto.getContrasena());
        Authentication authentication=this.authenticationManager.authenticate(login);

        String jwt=this.jwtUtil.create(dto.getDocumento());
        System.out.println(jwt);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,jwt).build();
    }
}
