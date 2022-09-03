package com.example.backpacientes.service;

import com.example.backpacientes.entity.AntecedentePatologico;

import java.util.List;
import java.util.UUID;


public interface AntecedentePatologicoService {
    List<AntecedentePatologico> findAntecedentePatologicoAll();
    AntecedentePatologico getAntecedentePatologico(UUID id);
    AntecedentePatologico createAntecedentePatologico(AntecedentePatologico paciente);
    AntecedentePatologico updateAntecedentePatologico(AntecedentePatologico paciente);
    String deleteAntecedentePatologico(UUID id);

}
