package com.example.backpacientes.service;

import com.example.backpacientes.entity.AntecedentesPatologicos;

import java.util.List;
import java.util.UUID;

public interface AntecedentesPatologicosService {
    List<AntecedentesPatologicos> findAntecedentesPatologicosAll();
    AntecedentesPatologicos getAntecedentesPatologicos(UUID id);
    AntecedentesPatologicos createAntecedentesPatologicos(AntecedentesPatologicos antecedentesPatologicos);
    AntecedentesPatologicos updateAntecedentesPatologicos(AntecedentesPatologicos antecedentesPatologicos);
    String deleteAntecedentesPatologicos(UUID id);
}
