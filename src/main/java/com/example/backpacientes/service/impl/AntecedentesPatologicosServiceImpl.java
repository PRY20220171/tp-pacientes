package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.AntecedentesPatologicos;
import com.example.backpacientes.repository.AntecedentesPatologicosRepository;
import com.example.backpacientes.service.AntecedentesPatologicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AntecedentesPatologicosServiceImpl implements AntecedentesPatologicosService {
    @Autowired
    private AntecedentesPatologicosRepository antecedentespatologicosRepository;

    @Override
    public List<AntecedentesPatologicos> findAntecedentesPatologicosAll() {
        return (List<AntecedentesPatologicos>) antecedentespatologicosRepository.findAll();
    }

    @Override
    public AntecedentesPatologicos getAntecedentesPatologicos(UUID id) {
        return antecedentespatologicosRepository.findById(id).orElse(null);
    }

    @Override
    public AntecedentesPatologicos createAntecedentesPatologicos(AntecedentesPatologicos antecedentespatologicos) {
        //Aquí irian las validaciones al crear el antecedentespatologicos de ser necesario
        return antecedentespatologicosRepository.save(antecedentespatologicos);
    }

    @Override
    public AntecedentesPatologicos updateAntecedentesPatologicos(AntecedentesPatologicos antecedentespatologicos) {
        AntecedentesPatologicos antecedentespatologicosDB = this.getAntecedentesPatologicos(antecedentespatologicos.getId());
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
    public String deleteAntecedentesPatologicos(UUID id) {
        AntecedentesPatologicos antecedentespatologicosDB = this.getAntecedentesPatologicos(id);
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
/*
    @Override
    public AntecedentesPatologicos getByDni(Long dni) {
        return antecedentespatologicosRepository.findAllByNeurologicoAndTransfsangre("DNI", dni.toString());
    }

    @Override
    public AntecedentesPatologicos getByDocExtranjeria(Long transfsangre) {
        return antecedentespatologicosRepository.findAllByNeurologicoAndTransfsangre("DOCUMENTO EXTRANJERIA", transfsangre.toString());
    }
*/
}
