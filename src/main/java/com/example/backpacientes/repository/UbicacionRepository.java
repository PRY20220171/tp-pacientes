package com.example.backpacientes.repository;

import com.example.backpacientes.entity.Ubicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.repository.Repository;
@Repository
public interface UbicacionRepository extends CrudRepository<Ubicacion, UUID> {
    //Ubicacion findOneById(String id);

    List<Ubicacion> findAllByPais(String pais);
    List<Ubicacion> findAllByPaisAndRegion(String pais, String region);
    List<Ubicacion> findAllByPaisAndRegionAndProvincia(String pais, String region, String provincia);
    List<Ubicacion> findAllByPaisAndRegionAndProvinciaAndDistrito(String pais, String region, String provincia, String distrito);

    //@Query("SELECT * from pizza_orders WHERE orderdate = ?0 and zoneid = ?1 ALLOW FILTERING")
    //Order findOrderByOrderDateAndZoneId(LocalDate orderDate, ZoneId zoneId);
}
