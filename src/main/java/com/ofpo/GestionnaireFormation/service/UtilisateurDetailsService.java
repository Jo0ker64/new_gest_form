package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Utilisateur;
import com.ofpo.GestionnaireFormation.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UtilisateurDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String adresseMail) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByAdresseMail(adresseMail);

        if (utilisateur == null) {
            System.out.println("Utilisateur introuvable : " + adresseMail);
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'adresse e-mail : " + adresseMail);
        }
        return new User(utilisateur.getAdresseMail(),
                utilisateur.getMotDePasse(),
                Collection.singletonList(new SimpleGrantedAuthority(utilisateur.getRoles())));

    }
//        if (!Boolean.TRUE.equals(utilisateur.getStatut())) {
//            System.out.println("Utilisateur désactivé : " + adresseMail);
//            throw new DisabledException("Utilisateur désactivé");
//        }
//
//        String[] roles = utilisateur.getRoles().stream()
//                .map(role -> role.getLibelle().toUpperCase()) // Assure que c'est bien USER, ADMIN
//                .toArray(String[]::new);
//
//        System.out.println("Utilisateur authentifié : " + utilisateur.getAdresseMail());
//        System.out.println("Rôles : " + Arrays.toString(roles));
//
//        return User.withUsername(utilisateur.getAdresseMail())
//                .password(utilisateur.getMotDePasse()) // Doit déjà être encodé (BCrypt)
//                .roles(roles) // Pas besoin de "ROLE_" ici
//                .build();
//    }
}
