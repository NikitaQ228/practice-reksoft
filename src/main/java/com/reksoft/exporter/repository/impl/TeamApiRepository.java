package com.reksoft.exporter.repository.impl;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.dto.TeamDto;
import com.reksoft.exporter.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamApiRepository implements TeamRepository {

    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    @Override
    public List<TeamDto> getTeams() {
        ResponseEntity<List<TeamDto>> response = restTemplate.exchange(
                apiProperties.getBaseUrl() + "/api/Teams",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }
}
