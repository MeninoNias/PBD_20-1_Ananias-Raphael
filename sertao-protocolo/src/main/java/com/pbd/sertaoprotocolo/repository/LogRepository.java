package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Long, Log> {
}
