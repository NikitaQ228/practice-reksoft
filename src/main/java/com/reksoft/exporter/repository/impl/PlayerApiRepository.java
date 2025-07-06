package com.reksoft.exporter.repository.impl;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.dto.PlayerDto;
import com.reksoft.exporter.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Repository
@RequiredArgsConstructor
public class PlayerApiRepository implements PlayerRepository {

    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    @Override
    public List<PlayerDto> getPlayers() {
        ResponseEntity<List<PlayerDto>> response = restTemplate.exchange(
                apiProperties.getBaseUrl() + "/api/Players",
                GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

}
