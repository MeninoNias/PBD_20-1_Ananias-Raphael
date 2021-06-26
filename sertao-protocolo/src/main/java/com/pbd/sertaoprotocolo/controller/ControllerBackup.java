package com.pbd.sertaoprotocolo.controller;


import com.pbd.sertaoprotocolo.service.BackupService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ControllerBackup {

    @Autowired
    private BackupService backupService;

    @GetMapping("/backup")
    public void downloadResource(HttpServletResponse response) {
        try {
            Path file = Paths.get(backupService.getBackup().getAbsolutePath());
            if (Files.exists(file)) {
                response.setContentType("application/file");
                response.addHeader("Content-Disposition", "attachment; filename=" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
