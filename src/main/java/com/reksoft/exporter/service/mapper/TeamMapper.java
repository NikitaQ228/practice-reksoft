package com.reksoft.exporter.service.mapper;

import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.dto.PlayerDto;
import com.reksoft.exporter.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    @Mapping(target = "playerNames", source = "players", qualifiedByName = "mapPlayersToNames")
    Team toTeam(TeamDto teamDto);

    @Named("mapPlayersToNames")
    default List<String> mapPlayersToNames(List<PlayerDto> players) {
        if (players == null) return Collections.emptyList();
        return players.stream()
                .map(PlayerDto::getCombinedName)
                .collect(Collectors.toList());
    }
}
