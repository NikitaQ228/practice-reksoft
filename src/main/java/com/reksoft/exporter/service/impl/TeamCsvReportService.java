package com.reksoft.exporter.service.impl;

import com.opencsv.CSVWriter;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.service.CsvReportService;
import com.reksoft.exporter.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamCsvReportService implements CsvReportService {

    private final TeamService teamService;

    @Override
    public File generateReport(String filePath) throws IOException {
        List<Team> teams = teamService.getTeams();

        File file = new File(filePath);
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            String[] header = {"id", "TeamName", "Players"};
            writer.writeNext(header);

            for (Team team : teams) {
                String[] line = {
                        String.valueOf(team.getId()),
                        team.getName(),
                        String.join(", ", team.getPlayerNames())
                };
                writer.writeNext(line);
            }
        }

        return file;
    }
}
