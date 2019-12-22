package com.aspect.interceptor.security;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


@Component
public class WebSecurity {
	
	public static boolean checkRole(Authentication authentication, HttpServletRequest request) {
		String checkRole = null;
		if (authentication instanceof KeycloakAuthenticationToken) {
			KeycloakPrincipal kp = (KeycloakPrincipal) ((KeycloakAuthenticationToken) authentication).getPrincipal();
			AccessToken token = kp.getKeycloakSecurityContext().getToken();
			for (String strRole : token.getRealmAccess().getRoles()) {
				return  true;
			}
			
		}
		return  false;
	}
}	
