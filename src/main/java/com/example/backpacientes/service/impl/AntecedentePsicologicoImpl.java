package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.AntecedentePerinatal;
import com.example.backpacientes.entity.AntecedentePsicologico;
import com.example.backpacientes.repository.AntecedentePsicologicoRepository;
import com.example.backpacientes.service.AntecedentePsicologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AntecedentePsicologicoImpl implements AntecedentePsicologicoService {

    @Autowired
    AntecedentePsicologicoRepository antecedentePsicologicoRepository;

    @Override
    public List<AntecedentePsicologico> findAntecedentePsicologicoAll() {
        return (List<AntecedentePsicologico>) antecedentePsicologicoRepository.findAll();
    }

    @Override
    public AntecedentePsicologico getAntecedentePsicologico(UUID id) {
        return antecedentePsicologicoRepository.findById(id).orElse(null);
    }

    @Override
    public AntecedentePsicologico createAntecedentePsicologico(AntecedentePsicologico antecedentePsicologico) {
        return antecedentePsicologicoRepository.save(antecedentePsicologico);
    }

    @Override
    public AntecedentePsicologico updateAntecedentePsicologico(AntecedentePsicologico antecedentePsicologico) {
        AntecedentePsicologico antecedentePsicologicoDB = this.getAntecedentePsicologico(antecedentePsicologico.getId());

        if (antecedentePsicologicoDB == null) {
            return null;
        }

        antecedentePsicologicoDB.setApoyofam(antecedentePsicologico.getApoyofam());
        antecedentePsicologicoDB.setEdadgestante(antecedentePsicologico.getEdadgestante());
        antecedentePsicologicoDB.setNrohijos(antecedentePsicologico.getNrohijos());
        antecedentePsicologicoDB.setEmbarazoespac(antecedentePsicologico.getEmbarazoespac());
        antecedentePsicologicoDB.setTipotrabajo(antecedentePsicologico.getTipotrabajo());
        antecedentePsicologicoDB.setViolenciaocupacional(antecedentePsicologico.getViolenciaocupacional());
        antecedentePsicologicoDB.setVidasocial(antecedentePsicologico.getVidasocial());
        antecedentePsicologicoDB.setPerteneceorg(antecedentePsicologico.getPerteneceorg());

        return antecedentePsicologicoRepository.save(antecedentePsicologicoDB);
    }

    @Override
    public String deleteAntecedentePsicologico(UUID id) {
        AntecedentePsicologico antecedentePsicologicoDB = this.getAntecedentePsicologico(id);

        if (antecedentePsicologicoDB == null) {
            return null;
        }

        try {
            antecedentePsicologicoRepository.delete(antecedentePsicologicoDB);
        } catch (Exception e) {
            return "ERROR INTERNO";
        }

        return "ELIMINADO CON EXITO";

    }
}
