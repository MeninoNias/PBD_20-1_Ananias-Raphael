package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
