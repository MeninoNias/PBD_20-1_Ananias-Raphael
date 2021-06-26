package com.pbd.sertaoprotocolo.backup;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Backup {

    private static final String SEPARATOR = File.separator;
    private final String path = "./backup/sertao_protocolo"+ LocalDate.now() + ".backup";

    private static final String POST_PATH_WIN =
            "C:" + SEPARATOR +
                    "Program Files" + SEPARATOR +
                    "PostgreSQL" + SEPARATOR +
                    "12" + SEPARATOR +
                    "bin" + SEPARATOR +
                    "pg_dump.exe";

    private static final String POST_PATH_LINUX =
            SEPARATOR +
                    "usr" + SEPARATOR +
                    "bin" + SEPARATOR +
                    "pg_dump";

    private static final String DATABASE = "sertao_protocolo";

    public void fazBackup() {
        String command = (System.getProperty("os.name").equalsIgnoreCase("Linux")) ? POST_PATH_LINUX : POST_PATH_WIN;
        System.out.println(command);

        File file = new File("./backup/");
        if (!file.exists()) {
            file.mkdirs();
        }

        ProcessBuilder pb = new ProcessBuilder(
                command,
                "-h",
                "localhost",
                "-U",
                "postgres",
                "-Ft",
                "-p",
                "5432",
                "-f",
                path,
                DATABASE);
        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

