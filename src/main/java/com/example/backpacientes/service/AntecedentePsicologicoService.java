package com.example.backpacientes.service;

import com.example.backpacientes.entity.AntecedentePsicologico;

import java.util.List;
import java.util.UUID;

public interface AntecedentePsicologicoService {

    List<AntecedentePsicologico> findAntecedentePsicologicoAll();
    AntecedentePsicologico getAntecedentePsicologico(UUID id);
    AntecedentePsicologico createAntecedentePsicologico(AntecedentePsicologico antecedentePsicologico);
    AntecedentePsicologico updateAntecedentePsicologico(AntecedentePsicologico antecedentePsicologico);
    String deleteAntecedentePsicologico(UUID id);

}
