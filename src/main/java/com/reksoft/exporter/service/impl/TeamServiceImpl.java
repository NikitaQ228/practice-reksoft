package com.reksoft.exporter.service.impl;

import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.impl.TeamApiRepository;
import com.reksoft.exporter.service.TeamService;
import com.reksoft.exporter.service.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamApiRepository teamApiRepository;
    private final TeamMapper teamMapper;

    @Override
    public List<Team> getTeams() {
        return teamApiRepository.getTeams().stream()
                .map(teamMapper::toTeam)
                .toList();
    }

}
