package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.AntecedentePatologico;
import com.example.backpacientes.repository.AntecedentePatologicoRepository;
import com.example.backpacientes.service.AntecedentePatologicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AntecedentePatologicoServiceImpl implements AntecedentePatologicoService {
    @Autowired
    private AntecedentePatologicoRepository antecedentespatologicosRepository;

    @Override
    public List<AntecedentePatologico> findAntecedentePatologicoAll() {
        return (List<AntecedentePatologico>) antecedentespatologicosRepository.findAll();
    }

    @Override
    public AntecedentePatologico getAntecedentePatologico(UUID id) {
        return antecedentespatologicosRepository.findById(id).orElse(null);
    }

    @Override
    public AntecedentePatologico createAntecedentePatologico(AntecedentePatologico antecedentespatologicos) {
        //Aquí irian las validaciones al crear el antecedentespatologicos de ser necesario
        return antecedentespatologicosRepository.save(antecedentespatologicos);
    }

    @Override
    public AntecedentePatologico updateAntecedentePatologico(AntecedentePatologico antecedentespatologicos) {
        AntecedentePatologico antecedentespatologicosDB = this.getAntecedentePatologico(antecedentespatologicos.getId());
        if (antecedentespatologicosDB == null) {
            return null;
        }
        //Actualizamos los valores del antecedentespatologicos:
        antecedentespatologicosDB.setTbc(antecedentespatologicos.getTbc());
        antecedentespatologicosDB.setSobasma(antecedentespatologicos.getSobasma());
        antecedentespatologicosDB.setTransfsangre(antecedentespatologicos.getTransfsangre());
        antecedentespatologicosDB.setNeurologico(antecedentespatologicos.getNeurologico());
        antecedentespatologicosDB.setAlergiamedic(antecedentespatologicos.getAlergiamedic());
        antecedentespatologicosDB.setOtros(antecedentespatologicos.getOtros());
        return antecedentespatologicosRepository.save(antecedentespatologicos);
    }

    @Override
    public String deleteAntecedentePatologico(UUID id) {
        AntecedentePatologico antecedentespatologicosDB = this.getAntecedentePatologico(id);
        if (antecedentespatologicosDB == null) {
            return null;
        }
        try{
            antecedentespatologicosRepository.delete(antecedentespatologicosDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
}
