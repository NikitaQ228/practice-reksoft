package com.reksoft.exporter.service.mapper;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "fullName", expression = "java(formatFullName(playerDto))")
    Player toPlayer(PlayerDto playerDto);

    default String formatFullName(PlayerDto playerDto) {
        String[] partsName = playerDto.getCombinedName().split("\\s+", 2);
        return String.format("%s \"%s\" %s", partsName[0], playerDto.getNickName(), partsName[1]);
    }
}
