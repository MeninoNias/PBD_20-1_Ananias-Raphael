package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Cargo;

import java.util.List;

public interface CargoService {

    List<Cargo> getCargos();

    Cargo getCargo(Long id);

    Cargo getCargoNome(String nome);

    Cargo createCargo(Cargo cargo);

    Cargo updateCargo(Cargo cargo);

    Cargo deleteCargo(Long id);
}
