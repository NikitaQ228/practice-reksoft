package com.reksoft.exporter.service.impl;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.impl.PlayerApiRepository;
import com.reksoft.exporter.service.PlayerService;
import com.reksoft.exporter.service.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerApiRepository playerApiRepository;
    private final PlayerMapper playerMapper;

    @Override
    public List<Player> getPlayers() {
        return playerApiRepository.getPlayers().stream()
                .map(playerMapper::toPlayer)
                .toList();
    }

}
