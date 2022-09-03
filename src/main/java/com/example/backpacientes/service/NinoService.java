package com.example.backpacientes.service;

import com.example.backpacientes.entity.Nino;

import java.util.List;
import java.util.UUID;

public interface NinoService {
    List<Nino> findNinoAll();
    Nino getNino(UUID id);
    Nino createNino(Nino nino);
    Nino updateNino(Nino nino);
    String deleteNino(UUID id);
}
