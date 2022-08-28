package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.Nino;
import com.example.backpacientes.repository.NinoRepository;
import com.example.backpacientes.service.NinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NinoServiceImpl implements NinoService {
    @Autowired
    private NinoRepository ninoRepository;

    @Override
    public List<Nino> findNinoAll() {
        return (List<Nino>) ninoRepository.findAll();
    }

    @Override
    public Nino getNino(UUID id) {
        return ninoRepository.findById(id).orElse(null);
    }

    @Override
    public Nino createNino(Nino nino) {
        //Aquí irian las validaciones al crear el nino de ser necesario
        return ninoRepository.save(nino);
    }

    @Override
    public Nino updateNino(Nino nino) {
        Nino ninoDB = this.getNino(nino.getId());
        if (ninoDB == null) {
            return null;
        }
        //Actualizamos los valores del nino:
        ninoDB.setTipoembarazo(nino.getTipoembarazo());
        ninoDB.setEmbarazoriesgo(nino.getEmbarazoriesgo());
        ninoDB.setControlprenatal(nino.getControlprenatal());
        ninoDB.setNroembarazo(nino.getNroembarazo());
        ninoDB.setEdadgestalnac(nino.getEdadgestalnac());
        ninoDB.setPesoalnac(nino.getPesoalnac());
        ninoDB.setTallaalnac(nino.getTallaalnac());
        ninoDB.setPerimcefalico(nino.getPerimcefalico());
        ninoDB.setRespllanto(nino.getRespllanto());
        return ninoRepository.save(nino);
    }

    @Override
    public String deleteNino(UUID id) {
        Nino ninoDB = this.getNino(id);
        if (ninoDB == null) {
            return null;
        }
        try{
            ninoRepository.delete(ninoDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public Nino getByDni(Long dni) {
        return ninoRepository.findAllByNroembarazoAndControlprenatal("DNI", dni.toString());
    }

    @Override
    public Nino getByDocExtranjeria(Long controlprenatal) {
        return ninoRepository.findAllByNroembarazoAndControlprenatal("DOCUMENTO EXTRANJERIA", controlprenatal.toString());
    }
*/
}
