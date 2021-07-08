package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Log;
import com.pbd.sertaoprotocolo.repository.LogRepository;
import com.pbd.sertaoprotocolo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<Log> getLogs() {
        return logRepository.findAll();
    }

    @Override
    public Log getLog(Long id) {
        return logRepository.findById(id).get();
    }

    @Override
    public Log createLog(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log updateLog(Log log) {
        return logRepository.save(log);
    }

    @Override
    public Log deleteLog(Long id) {
        return null;
    }
}
