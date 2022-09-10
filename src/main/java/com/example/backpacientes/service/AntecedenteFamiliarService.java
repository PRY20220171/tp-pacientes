package com.example.backpacientes.service;

import com.example.backpacientes.entity.AntecedenteFamiliar;

import java.util.List;
import java.util.UUID;

public interface AntecedenteFamiliarService {
    List<AntecedenteFamiliar> findAntecedenteFamiliarAll();
    AntecedenteFamiliar getAntecedenteFamiliar(UUID id);
    AntecedenteFamiliar createAntecedenteFamiliar(AntecedenteFamiliar antecedentefamiliar);
    AntecedenteFamiliar updateAntecedenteFamiliar(AntecedenteFamiliar antecedentefamiliar);
    String deleteAntecedenteFamiliar(UUID id);
}
