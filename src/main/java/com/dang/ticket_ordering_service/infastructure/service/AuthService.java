package com.dang.ticket_ordering_service.infastructure.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${auth.service.url}")
    private final String authServiceUrl;

    public AuthService(@Value("${auth.service.url}") String authServiceUrl) {
        this.authServiceUrl = authServiceUrl;
    }

    public boolean validateToken(String token) {
        return Boolean.TRUE.equals(restTemplate.getForObject(authServiceUrl + "/validateToken?token=" + token, Boolean.class));
    }

    public int getUserId(String token) {
        var result = restTemplate.getForObject(authServiceUrl + "/getUserId?token=" + token, Integer.class);
        if (result == null) {
            return 0;
        }
        return result;
    }
}
