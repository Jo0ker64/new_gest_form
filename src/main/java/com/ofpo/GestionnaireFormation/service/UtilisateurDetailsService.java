package com.ofpo.GestionnaireFormation.service;

import com.ofpo.GestionnaireFormation.model.Utilisateur;
import com.ofpo.GestionnaireFormation.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByAdresseMail(email);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + email);
        }

        // 💡 Ne pas préfixer avec ROLE_ ici, Spring le fait tout seul
        String[] roles = utilisateur.getRoles()
                .stream()
                .map(role -> role.getLibelle().toUpperCase()) // Ex: "UTILISATEUR", "ADMIN"
                .toArray(String[]::new);

        System.out.println("Chargement utilisateur : " + email);
        System.out.println("Rôles utilisés : " + String.join(", ", roles));

        return User.withUsername(utilisateur.getAdresseMail())
                .password(utilisateur.getMotDePasse()) // bcrypt déjà encodé
                .roles(roles) // Spring ajoute automatiquement le prefixe ROLE_
                .build();
    }
}
