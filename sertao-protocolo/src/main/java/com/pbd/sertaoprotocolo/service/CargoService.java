package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Cargo;

import java.util.List;

public interface CargoService {

    List<Cargo> getCargos();
    Cargo getCargo(Long id);
    Cargo createCargo(Cargo cargo);
    Cargo updateCargo(Long id, Cargo cargo);
    Cargo deleteCargo(Long id);
}
