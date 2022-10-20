package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.AntecedenteFamiliar;
import com.example.backpacientes.repository.AntecedenteFamiliarRepository;
import com.example.backpacientes.service.AntecedenteFamiliarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AntecedenteFamiliarServiceImpl implements AntecedenteFamiliarService {
    @Autowired
    private AntecedenteFamiliarRepository antecedentefamiliarRepository;

    @Override
    public List<AntecedenteFamiliar> findAntecedenteFamiliarAll() {
        return (List<AntecedenteFamiliar>) antecedentefamiliarRepository.findAll();
    }

    @Override
    public AntecedenteFamiliar getAntecedenteFamiliar(UUID id) {
        return antecedentefamiliarRepository.findById(id).orElse(null);
    }

    @Override
    public AntecedenteFamiliar createAntecedenteFamiliar(AntecedenteFamiliar antecedentefamiliar) {
        //Aquí irian las validaciones al crear el antecedentefamiliar de ser necesario
        return antecedentefamiliarRepository.save(antecedentefamiliar);
    }

    @Override
    public AntecedenteFamiliar updateAntecedenteFamiliar(AntecedenteFamiliar antecedentefamiliar) {
        AntecedenteFamiliar antecedentefamiliarDB = this.getAntecedenteFamiliar(antecedentefamiliar.getId());
        if (antecedentefamiliarDB == null) {
            return null;
        }
        //Actualizamos los valores del antecedentefamiliar:
        antecedentefamiliarDB.setTbc(antecedentefamiliar.getTbc());
        antecedentefamiliarDB.setVihsida(antecedentefamiliar.getVihsida());
        antecedentefamiliarDB.setDiabetes(antecedentefamiliar.getDiabetes());
        antecedentefamiliarDB.setEpilepsia(antecedentefamiliar.getEpilepsia());
        antecedentefamiliarDB.setAlergiamedic(antecedentefamiliar.getAlergiamedic());
        antecedentefamiliarDB.setViolenciafam(antecedentefamiliar.getViolenciafam());
        //antecedentefamiliarDB.setAlcoholismo(antecedentefamiliar.getAlcoholismo());
        antecedentefamiliarDB.setDrogadiccion(antecedentefamiliar.getDrogadiccion());
        antecedentefamiliarDB.setHepatitisb(antecedentefamiliar.getHepatitisb());
        return antecedentefamiliarRepository.save(antecedentefamiliar);
    }

    @Override
    public String deleteAntecedenteFamiliar(UUID id) {
        AntecedenteFamiliar antecedentefamiliarDB = this.getAntecedenteFamiliar(id);
        if (antecedentefamiliarDB == null) {
            return null;
        }
        try{
            antecedentefamiliarRepository.delete(antecedentefamiliarDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
/*
    @Override
    public AntecedenteFamiliar getByDni(Long dni) {
        return antecedentefamiliarRepository.findAllByEpilepsiaAndDiabetes("DNI", dni.toString());
    }

    @Override
    public AntecedenteFamiliar getByDocExtranjeria(Long diabetes) {
        return antecedentefamiliarRepository.findAllByEpilepsiaAndDiabetes("DOCUMENTO EXTRANJERIA", diabetes.toString());
    }
*/
}
