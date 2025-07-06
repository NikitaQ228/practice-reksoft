package com.reksoft.exporter.controller;

import com.reksoft.exporter.service.CsvReportService;
import com.reksoft.exporter.service.impl.PlayerCsvReportService;
import com.reksoft.exporter.service.impl.TeamCsvReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final PlayerCsvReportService playerReportService;
    private final TeamCsvReportService teamReportService;
    private final Clock clock;

    @GetMapping
    public String getReportPage() {
        return "report.html";
    }

    @GetMapping("/player/download")
    public ResponseEntity<Resource> downloadPlayerReport() throws IOException {
        return downloadReport(playerReportService, "player_report");
    }

    @GetMapping("/team/download")
    public ResponseEntity<Resource> downloadTeamReport() throws IOException {
        return downloadReport(teamReportService, "team_report");
    }

    // Общий метод для скачивания отчетов
    private ResponseEntity<Resource> downloadReport(CsvReportService reportService, String filenamePrefix) throws IOException {
        String timestamp = LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "%s_%s.csv".formatted(filenamePrefix, timestamp);
        String filePath = System.getProperty("java.io.tmpdir") + File.separator + filename;
        File reportFile = reportService.generateReport(filePath);

        FileSystemResource resource = new FileSystemResource(reportFile);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentLength(Files.size(reportFile.toPath()))
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(resource);
    }
}
