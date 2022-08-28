package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.AntecedentePerinatal;
import com.example.backpacientes.repository.AntecedentePerinatalRepository;
import com.example.backpacientes.service.AntecedentePerinatalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AntecedentePerinatalServiceImpl implements AntecedentePerinatalService {
    @Autowired
    private AntecedentePerinatalRepository antecedenteperinatalRepository;

    @Override
    public List<AntecedentePerinatal> findAntecedentePerinatalAll() {
        return (List<AntecedentePerinatal>) antecedenteperinatalRepository.findAll();
    }

    @Override
    public AntecedentePerinatal getAntecedentePerinatal(UUID id) {
        return antecedenteperinatalRepository.findById(id).orElse(null);
    }

    @Override
    public AntecedentePerinatal createAntecedentePerinatal(AntecedentePerinatal antecedenteperinatal) {
        //Aquí irian las validaciones al crear el antecedenteperinatal de ser necesario
        return antecedenteperinatalRepository.save(antecedenteperinatal);
    }

    @Override
    public AntecedentePerinatal updateAntecedentePerinatal(AntecedentePerinatal antecedenteperinatal) {
        AntecedentePerinatal antecedenteperinatalDB = this.getAntecedentePerinatal(antecedenteperinatal.getId());
        if (antecedenteperinatalDB == null) {
            return null;
        }
        //Actualizamos los valores del antecedenteperinatal:
        antecedenteperinatalDB.setApoyofam(antecedenteperinatal.getApoyofam());
        antecedenteperinatalDB.setEdadgestante(antecedenteperinatal.getEdadgestante());
        antecedenteperinatalDB.setNrohijos(antecedenteperinatal.getNrohijos());
        antecedenteperinatalDB.setEmbarazoespac(antecedenteperinatal.getEmbarazoespac());
        return antecedenteperinatalRepository.save(antecedenteperinatal);
    }

    @Override
    public String deleteAntecedentePerinatal(UUID id) {
        AntecedentePerinatal antecedenteperinatalDB = this.getAntecedentePerinatal(id);
        if (antecedenteperinatalDB == null) {
            return null;
        }
        try{
            antecedenteperinatalRepository.delete(antecedenteperinatalDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public AntecedentePerinatal getByDni(Long dni) {
        return antecedenteperinatalRepository.findAllByEmbarazoespacAndNrohijos("DNI", dni.toString());
    }

    @Override
    public AntecedentePerinatal getByDocExtranjeria(Long nrohijos) {
        return antecedenteperinatalRepository.findAllByEmbarazoespacAndNrohijos("DOCUMENTO EXTRANJERIA", nrohijos.toString());
    }
*/
}
