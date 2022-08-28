package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.Paciente;
import com.example.backpacientes.repository.PacienteRepository;
import com.example.backpacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findPacienteAll() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @Override
    public Paciente getPaciente(UUID id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente createPaciente(Paciente paciente) {
        //Aquí irian las validaciones al crear el paciente de ser necesario
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
