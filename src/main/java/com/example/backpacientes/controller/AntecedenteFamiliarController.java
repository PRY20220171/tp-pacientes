package com.example.backpacientes.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backpacientes.entity.AntecedenteFamiliar;
import com.example.backpacientes.service.AntecedenteFamiliarService;
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
@RequestMapping("/antecedentesfamiliares")
public class AntecedenteFamiliarController {
    @Autowired
    private AntecedenteFamiliarService antecedentefamiliarService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de antecedente familiar por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=AntecedenteFamiliar.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<AntecedenteFamiliar>> listAntecedenteFamiliar(@RequestParam(name="idantecedentefam",required = false) String idAntecedenteFamiliar){
        List<AntecedenteFamiliar> antecedentesfamiliares=new ArrayList<>();
        if(null==idAntecedenteFamiliar){
            antecedentesfamiliares=antecedentefamiliarService.findAntecedenteFamiliarAll();
            if(antecedentesfamiliares.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            antecedentesfamiliares = Collections.singletonList(antecedentefamiliarService.getAntecedenteFamiliar(UUID.fromString(idAntecedenteFamiliar)));
        }
        return ResponseEntity.ok(antecedentesfamiliares);
    }

    @PostMapping
    public ResponseEntity<AntecedenteFamiliar> createAntecedenteFamiliar(@Valid @RequestBody AntecedenteFamiliar antecedentefamiliar, BindingResult result){
        antecedentefamiliar.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        AntecedenteFamiliar antecedentefamiliarcreate = antecedentefamiliarService.createAntecedenteFamiliar(antecedentefamiliar);
        return ResponseEntity.status(HttpStatus.CREATED).body(antecedentefamiliarcreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AntecedenteFamiliar> updateAntecedenteFamiliar(@PathVariable("id") String id, @RequestBody AntecedenteFamiliar antecedentefamiliar){
        antecedentefamiliar.setId(UUID.fromString(id));
        AntecedenteFamiliar antecedentefamiliarDB=antecedentefamiliarService.updateAntecedenteFamiliar(antecedentefamiliar);
        if(antecedentefamiliarDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(antecedentefamiliarDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAntecedenteFamiliar(@PathVariable("id") String id){
        String antecedentefamiliarDelete=antecedentefamiliarService.deleteAntecedenteFamiliar(UUID.fromString(id));
        if(antecedentefamiliarDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(antecedentefamiliarDelete);
    }

    /*
    @Autowired
    ProducerService rabbitMQSender;
    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new AntecedenteFamiliar());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

     */



}
