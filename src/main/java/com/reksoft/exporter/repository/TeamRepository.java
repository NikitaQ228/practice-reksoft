package com.reksoft.exporter.repository;

import com.reksoft.exporter.dto.TeamDto;

import java.util.List;

public interface TeamRepository {
    List<TeamDto> getTeams();
}
