package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Log;

import java.util.List;

public interface LogService {
    List<Log> getLogs();

    Log getLog(Long id);

    Log createLog(Log instituicao);

    Log updateLog(Log instituicao);

    Log deleteLog(Long id);
}
