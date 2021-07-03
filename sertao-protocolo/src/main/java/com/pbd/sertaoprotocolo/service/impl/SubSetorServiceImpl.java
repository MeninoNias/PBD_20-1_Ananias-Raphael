package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.SubSetor;
import com.pbd.sertaoprotocolo.repository.SubSetorRepository;
import com.pbd.sertaoprotocolo.service.SubSetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSetorServiceImpl implements SubSetorService {

    @Autowired
    SubSetorRepository subSetorRepository;

    @Override
    public List<SubSetor> getSubSetors() {
        return subSetorRepository.findByAtivoBanco(true);
    }

    @Override
    public SubSetor getSubSetor(Long id) {
        return subSetorRepository.findById(id).get();
    }

    @Override
    public SubSetor createSubSetor(SubSetor subSetor) {
        return subSetorRepository.save(subSetor);
    }

    @Override
    public SubSetor updateSubSetor(SubSetor subSetor) {
        return subSetorRepository.save(subSetor);
    }

    @Override
    public SubSetor deleteSubSetor(Long id) {
        SubSetor subsetor = getSubSetor(id);
        subsetor.setAtivoBanco(false);
        updateSubSetor(subsetor);
        return subsetor;
    }


}
