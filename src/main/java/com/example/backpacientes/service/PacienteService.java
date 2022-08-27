package com.example.backpacientes.service;

import com.example.backpacientes.entity.Paciente;

import java.util.List;
import java.util.UUID;

public interface PacienteService {
    List<Paciente> findPacienteAll();
    Paciente getPaciente(UUID id);
    Paciente createPaciente(Paciente paciente);
    Paciente updatePaciente(Paciente paciente);
    String deletePaciente(UUID id);
    Paciente getByDni(Long dni);
    Paciente getByDocExtranjeria(Long docnum);
}
