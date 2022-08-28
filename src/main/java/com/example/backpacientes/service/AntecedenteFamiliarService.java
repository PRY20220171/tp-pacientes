package com.example.backpacientes.service;

import com.example.backpacientes.entity.AntecedenteFamiliar;

import java.util.List;
import java.util.UUID;

public interface AntecedenteFamiliarService {
    List<AntecedenteFamiliar> findAntecedenteFamiliarAll();
    AntecedenteFamiliar getAntecedenteFamiliar(UUID id);
    AntecedenteFamiliar createAntecedenteFamiliar(AntecedenteFamiliar paciente);
    AntecedenteFamiliar updateAntecedenteFamiliar(AntecedenteFamiliar paciente);
    String deleteAntecedenteFamiliar(UUID id);
    AntecedenteFamiliar getByDni(Long dni);
    AntecedenteFamiliar getByDocExtranjeria(Long docnum);
}
