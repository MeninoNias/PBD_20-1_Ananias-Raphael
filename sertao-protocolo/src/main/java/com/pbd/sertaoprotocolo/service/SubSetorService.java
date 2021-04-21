package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.SubSetor;

import java.util.List;

public interface SubSetorService {

    List<SubSetor> getSubSetors();
    SubSetor getSubSetor(Long id);
    SubSetor createSubSetor(SubSetor subSetor);
    SubSetor updateSubSetor(Long id, SubSetor subSetor);
    SubSetor deleteSubSetor(Long id);


}
