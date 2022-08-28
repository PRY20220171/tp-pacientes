package com.example.backpacientes.service;

import com.example.backpacientes.entity.AntecedentesPatologicos;

import java.util.List;
import java.util.UUID;

public interface AntecedentesPatologicosService {
    List<AntecedentesPatologicos> findAntecedentesPatologicosAll();
    AntecedentesPatologicos getAntecedentesPatologicos(UUID id);
    AntecedentesPatologicos createAntecedentesPatologicos(AntecedentesPatologicos paciente);
    AntecedentesPatologicos updateAntecedentesPatologicos(AntecedentesPatologicos paciente);
    String deleteAntecedentesPatologicos(UUID id);
    AntecedentesPatologicos getByDni(Long dni);
    AntecedentesPatologicos getByDocExtranjeria(Long docnum);
}
