package com.example.backpacientes.service;

import com.example.backpacientes.entity.AntecedentePerinatal;

import java.util.List;
import java.util.UUID;

public interface AntecedentePerinatalService {
    List<AntecedentePerinatal> findAntecedentePerinatalAll();
    AntecedentePerinatal getAntecedentePerinatal(UUID id);
    AntecedentePerinatal createAntecedentePerinatal(AntecedentePerinatal paciente);
    AntecedentePerinatal updateAntecedentePerinatal(AntecedentePerinatal paciente);
    String deleteAntecedentePerinatal(UUID id);
    AntecedentePerinatal getByDni(Long dni);
    AntecedentePerinatal getByDocExtranjeria(Long docnum);
}
