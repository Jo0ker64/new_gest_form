package com.ofpo.GestionnaireFormation.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    @Value("${app.secret-key}")
    private String secretKey;
}
