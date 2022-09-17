package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.Paciente;
import com.example.backpacientes.repository.*;
import com.example.backpacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UbicacionRepository ubicacionRepository;
    @Autowired
    private NinoRepository ninoRepository;
    @Autowired
    private AntecedentePatologicoRepository antecedentePatologicoRepository;
    @Autowired
    private AntecedenteFamiliarRepository antecedenteFamiliarRepository;
    @Autowired
    private AntecedentePerinatalRepository antecedentePerinatalRepository;
    @Override
    public List<Paciente> findPacienteAll() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @Override
    public Paciente getPaciente(UUID id) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if (paciente != null){
            paciente.setLugarnac(ubicacionRepository.findById(paciente.getIdlugarnac()).orElse(null));
            paciente.setNino(ninoRepository.findById(paciente.getIdnino()).orElse(null));
            paciente.setAntecedentepato(antecedentePatologicoRepository.findById(paciente.getIdantecedentepato()).orElse(null));
            paciente.setAntecedentefam(antecedenteFamiliarRepository.findById(paciente.getIdantecedentefam()).orElse(null));
            paciente.setAntecedenteperi(antecedentePerinatalRepository.findById(paciente.getIdantecedenteperi()).orElse(null));
        }
        return paciente;
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        //Aquí irian las validaciones al crear el paciente de ser necesario
        paciente.setIdlugarnac(ubicacionRepository.save(paciente.getLugarnac()).getId());
        paciente.setIddomicilioact(ubicacionRepository.save(paciente.getDomicilioact()).getId());
        paciente.setIdnino(ninoRepository.save(paciente.getNino()).getId());
        paciente.setIdantecedentepato(antecedentePatologicoRepository.save(paciente.getAntecedentepato()).getId());
        paciente.setIdantecedentefam(antecedenteFamiliarRepository.save(paciente.getAntecedentefam()).getId());
        paciente.setIdantecedenteperi(antecedentePerinatalRepository.save(paciente.getAntecedenteperi()).getId());
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Paciente paciente) {
        Paciente pacienteDB = this.getPaciente(paciente.getId());
        if (pacienteDB == null) {
            return null;
        }
        //Actualizamos los valores del paciente:
        pacienteDB.setNombres(paciente.getNombres());
        pacienteDB.setApellidos(paciente.getApellidos());
        pacienteDB.setDocnum(paciente.getDocnum());
        pacienteDB.setDoctipo(paciente.getDoctipo());
        pacienteDB.setSexo(paciente.getSexo());
        pacienteDB.setGruposang(paciente.getGruposang());
        pacienteDB.setRh(paciente.getRh());
        pacienteDB.setTelefono(paciente.getTelefono());
        pacienteDB.setGradoinstruccion(paciente.getGradoinstruccion());
        pacienteDB.setOcupacion(paciente.getOcupacion());
        pacienteDB.setEstadocivil(paciente.getEstadocivil());
        return pacienteRepository.save(paciente);
    }

    @Override
    public String deletePaciente(UUID id) {
        Paciente pacienteDB = this.getPaciente(id);
        if (pacienteDB == null) {
            return null;
        }
        try{
            pacienteRepository.delete(pacienteDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public Paciente getByDni(Long dni) {
        return pacienteRepository.findAllByDoctipoAndDocnum("DNI", dni.toString());
    }

    @Override
    public Paciente getByDocExtranjeria(Long docnum) {
        return pacienteRepository.findAllByDoctipoAndDocnum("DOCUMENTO EXTRANJERIA", docnum.toString());
    }

 */
}
