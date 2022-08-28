package com.example.backpacientes.repository;

import com.example.backpacientes.entity.AntecedentesPatologicos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.Repository;
@Repository
public interface AntecedentesPatologicosRepository extends CrudRepository<AntecedentesPatologicos, UUID> {
    //AntecedentesPatologicos findOneById(String id);
    //AntecedentesPatologicos findAllByDoctipoAndDocnum(String doctipo, String docnum);
    //@Query("SELECT * from pizza_orders WHERE orderdate = ?0 and zoneid = ?1 ALLOW FILTERING")
    //Order findOrderByOrderDateAndZoneId(LocalDate orderDate, ZoneId zoneId);
}
