package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.backup.Backup;
import com.pbd.sertaoprotocolo.service.BackupService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;

@Service
public class BackupServiceImpl implements BackupService {

    @Override
    public File getBackup() {

        String path = "./backup/sertao_protocolo"+ LocalDate.now() + ".backup";

        File file = new File(path);
        if(!file.exists()){
            Backup backup = new Backup();
            backup.fazBackup();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            file = new File(path);
        }

        return file;
    }
}
