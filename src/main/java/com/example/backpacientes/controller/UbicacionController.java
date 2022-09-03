package com.example.backpacientes.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backpacientes.entity.Ubicacion;
import com.example.backpacientes.service.UbicacionService;
import com.example.backpacientes.service.ProducerService;
import com.example.backpacientes.util.ErrorMessage;
import com.example.backpacientes.util.Message;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de una ubicacion por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=Ubicacion.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<Ubicacion>> listUbicacion(@RequestParam(name="idubicacion",required = false) String idUbicacion){
        List<Ubicacion> ubicacions=new ArrayList<>();
        if(null==idUbicacion){
            ubicacions=ubicacionService.findUbicacionAll();
            if(ubicacions.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            ubicacions = Collections.singletonList(ubicacionService.getUbicacion(UUID.fromString(idUbicacion)));
        }
        return ResponseEntity.ok(ubicacions);
    }

    @PostMapping
    public ResponseEntity<Ubicacion> createUbicacion(@Valid @RequestBody Ubicacion ubicacion, BindingResult result){
        ubicacion.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Ubicacion ubicacioncreate = ubicacionService.createUbicacion(ubicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(ubicacioncreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ubicacion> updateUbicacion(@PathVariable("id") String id, @RequestBody Ubicacion ubicacion){
        ubicacion.setId(UUID.fromString(id));
        Ubicacion ubicacionDB=ubicacionService.updateUbicacion(ubicacion);
        if(ubicacionDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ubicacionDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUbicacion(@PathVariable("id") String id){
        String ubicacionDelete=ubicacionService.deleteUbicacion(UUID.fromString(id));
        if(ubicacionDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ubicacionDelete);
    }

    @Autowired
    ProducerService rabbitMQSender;
/*
    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new Ubicacion());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

 */



}
