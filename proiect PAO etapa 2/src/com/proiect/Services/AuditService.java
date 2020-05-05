package com.proiect.Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static final String LOG_LOCATION = "./audit.csv";

    private static AuditService ourInstance = new AuditService();

    public static AuditService getInstance() {

        return ourInstance;
    }

    public void writeLogLine(String action) {
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String timestamp = dateNow.format(formatObj);
        WriteService.scrieCsv(LOG_LOCATION,new String[]{action,timestamp});
    }
}
