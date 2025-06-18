//package com.ofpo.GestionnaireFormation.controller;
//
//import com.ofpo.GestionnaireFormation.DTO.utilisateur.LoginRequest;
//import com.ofpo.GestionnaireFormation.DTO.utilisateur.LoginResponse;
//import com.ofpo.GestionnaireFormation.security.JwtService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtService jwtService;
//
//    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtService = jwtService;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            request.getEmail(),
//                            request.getPassword()
//                    )
//            );
//
//            String token = jwtService.generateToken(request.getEmail());
//            System.out.println("Authentification réussie pour : " + request.getEmail());
//            return ResponseEntity.ok(new LoginResponse(token));
//
//        } catch (AuthenticationException ex) {
//            System.out.println("Échec d’authentification pour : " + request.getEmail());
//            return ResponseEntity.status(403).build();
//        }
//    }
//}

package com.ofpo.GestionnaireFormation.controller;

import com.ofpo.GestionnaireFormation.DTO.utilisateur.LoginRequest;
import com.ofpo.GestionnaireFormation.DTO.utilisateur.LoginResponse;
import com.ofpo.GestionnaireFormation.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            String token = jwtService.generateToken(request.getEmail());
            System.out.println("Connexion réussie pour : " + request.getEmail());
            return ResponseEntity.ok(new LoginResponse(token));

        } catch (BadCredentialsException e) {
            System.out.println("Mauvais identifiants pour : " + request.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Email ou mot de passe incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur inconnue lors du login : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la tentative de connexion");
        }
    }
}
