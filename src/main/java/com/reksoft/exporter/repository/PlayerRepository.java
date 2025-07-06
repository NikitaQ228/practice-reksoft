package com.reksoft.exporter.repository;

import com.reksoft.exporter.dto.PlayerDto;

import java.util.List;

public interface PlayerRepository {

    List<PlayerDto> getPlayers();
}
