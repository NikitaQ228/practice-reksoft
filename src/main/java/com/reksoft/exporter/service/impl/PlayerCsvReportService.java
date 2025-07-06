package com.reksoft.exporter.service.impl;

import com.opencsv.CSVWriter;
import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.service.CsvReportService;
import com.reksoft.exporter.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerCsvReportService implements CsvReportService {

    private final PlayerService playerService;

    @Override
    public File generateReport(String filePath) throws IOException {
        List<Player> players = playerService.getPlayers();

        File file = new File(filePath);
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            String[] header = {"ID", "Combined Name", "Nickname", "Country", "Team Name", "Full Name"};
            writer.writeNext(header);

            for (Player player : players) {
                String[] line = {
                        String.valueOf(player.getId()),
                        player.getCombinedName(),
                        player.getNickName(),
                        player.getCountry() != null ? String.valueOf(player.getCountry()) : "",
                        player.getTeamName(),
                        player.getFullName()
                };
                writer.writeNext(line);
            }
        }

        return file;
    }
}
