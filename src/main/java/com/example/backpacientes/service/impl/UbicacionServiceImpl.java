package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.Ubicacion;
import com.example.backpacientes.repository.UbicacionRepository;
import com.example.backpacientes.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UbicacionServiceImpl implements UbicacionService {
    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Override
    public List<Ubicacion> findUbicacionAll() {
        return (List<Ubicacion>) ubicacionRepository.findAll();
    }

    @Override
    public Ubicacion getUbicacion(UUID id) {
        return ubicacionRepository.findById(id).orElse(null);
    }

    @Override
    public Ubicacion createUbicacion(Ubicacion ubicacion) {
        //Aquí irian las validaciones al crear el ubicacion de ser necesario
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public Ubicacion updateUbicacion(Ubicacion ubicacion) {
        Ubicacion ubicacionDB = this.getUbicacion(ubicacion.getId());
        if (ubicacionDB == null) {
            return null;
        }
        //Actualizamos los valores del ubicacion:
        ubicacionDB.setPais(ubicacion.getPais());
        ubicacionDB.setRegion(ubicacion.getRegion());
        ubicacionDB.setProvincia(ubicacion.getProvincia());
        ubicacionDB.setDistrito(ubicacion.getDistrito());
        ubicacionDB.setDireccion(ubicacion.getDireccion());
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public String deleteUbicacion(UUID id) {
        Ubicacion ubicacionDB = this.getUbicacion(id);
        if (ubicacionDB == null) {
            return null;
        }
        try{
            ubicacionRepository.delete(ubicacionDB);
        }catch (Exception e){
            return "ERROR INTERNO";
        }
        return "ELIMINADO CON EXITO";
    }
    /*
    @Override
    public Ubicacion getByDni(Long dni) {
        return ubicacionRepository.findAllByDoctipoAndDocnum("DNI", dni.toString());
    }

    @Override
    public Ubicacion getByDocExtranjeria(Long docnum) {
        return ubicacionRepository.findAllByDoctipoAndDocnum("DOCUMENTO EXTRANJERIA", docnum.toString());
    }
    */
}
