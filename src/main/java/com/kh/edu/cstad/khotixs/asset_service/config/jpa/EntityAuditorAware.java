package com.kh.edu.cstad.khotixs.asset_service.config.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Optional;

@Slf4j
public class EntityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth==null|| !(auth instanceof JwtAuthenticationToken jwtAuth)) {
            return Optional.of("KHOTIXS");
        }

        String uuid = jwtAuth.getToken().getClaimAsString("uuid");

        return Optional.ofNullable(uuid).or(() -> Optional.of("KHOTIXS"));
    }
}