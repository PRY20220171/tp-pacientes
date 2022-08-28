package com.example.backpacientes.service;

import com.example.backpacientes.entity.Ubicacion;

import java.util.List;
import java.util.UUID;

public interface UbicacionService {
    List<Ubicacion> findUbicacionAll();
    Ubicacion getUbicacion(UUID id);
    Ubicacion createUbicacion(Ubicacion paciente);
    Ubicacion updateUbicacion(Ubicacion paciente);
    String deleteUbicacion(UUID id);
    /*
    Ubicacion getByDni(Long dni);
    Ubicacion getByDocExtranjeria(Long docnum);
     */
}
