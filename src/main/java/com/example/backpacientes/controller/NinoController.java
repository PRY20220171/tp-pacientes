package com.example.backpacientes.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backpacientes.entity.Nino;
import com.example.backpacientes.service.NinoService;
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
@RequestMapping("/ninos")
public class NinoController {
    @Autowired
    private NinoService ninoService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de la etapa niño del paciente por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=Nino.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<Nino>> listNino(@RequestParam(name="idnino",required = false) String idNino){
        List<Nino> ninos=new ArrayList<>();
        if(null==idNino){
            ninos=ninoService.findNinoAll();
            if(ninos.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            ninos = Collections.singletonList(ninoService.getNino(UUID.fromString(idNino)));
        }
        return ResponseEntity.ok(ninos);
    }

    @PostMapping
    public ResponseEntity<Nino> createNino(@Valid @RequestBody Nino nino, BindingResult result){
        nino.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Nino ninocreate = ninoService.createNino(nino);
        return ResponseEntity.status(HttpStatus.CREATED).body(ninocreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nino> updateNino(@PathVariable("id") String id, @RequestBody Nino nino){
        nino.setId(UUID.fromString(id));
        Nino ninoDB=ninoService.updateNino(nino);
        if(ninoDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ninoDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNino(@PathVariable("id") String id){
        String ninoDelete=ninoService.deleteNino(UUID.fromString(id));
        if(ninoDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ninoDelete);
    }

    @Autowired
    ProducerService rabbitMQSender;
/*
    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new Nino());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

 */



}
