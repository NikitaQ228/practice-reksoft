package com.reksoft.exporter.service;

import java.io.File;
import java.io.IOException;

public interface CsvReportService {

    File generateReport(String filePath) throws IOException;
}
