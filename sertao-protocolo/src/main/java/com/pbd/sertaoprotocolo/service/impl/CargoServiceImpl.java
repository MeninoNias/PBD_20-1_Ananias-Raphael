package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Cargo;
import com.pbd.sertaoprotocolo.repository.CargoRepository;
import com.pbd.sertaoprotocolo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    CargoRepository cargoRepository;

    @Override
    public List<Cargo> getCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo getCargo(Long id) {
        return cargoRepository.findById(id).get();
    }

    @Override
    public Cargo getCargoNome(String nome) {
        return cargoRepository.findByNome(nome);
    }

    @Override
    public Cargo createCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Cargo updateCargo(Long id, Cargo cargo) {
        Cargo c = cargoRepository.findById(id).get();
        c.setNome(cargo.getNome());
        cargoRepository.save(c);
        return c;
    }

    @Override
    public Cargo deleteCargo(Long id) {
        return null;
    }
}
