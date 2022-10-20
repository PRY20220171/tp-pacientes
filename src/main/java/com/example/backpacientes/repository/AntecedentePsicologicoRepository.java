package com.example.backpacientes.repository;

import com.example.backpacientes.entity.AntecedentePsicologico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AntecedentePsicologicoRepository extends CrudRepository<AntecedentePsicologico, UUID> {



}
