package com.example.backpacientes.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backpacientes.entity.AntecedentePerinatal;
import com.example.backpacientes.service.AntecedentePerinatalService;
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
@RequestMapping("/antecedentesperinatales")
public class AntecedentePerinatalController {
    @Autowired
    private AntecedentePerinatalService antecedenteperinatalService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de antecedente perinatal por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=AntecedentePerinatal.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<AntecedentePerinatal>> listAntecedentePerinatal(@RequestParam(name="idantecedenteperinatal",required = false) String idAntecedentePerinatal){
        List<AntecedentePerinatal> antecedentesperinatales=new ArrayList<>();
        if(null==idAntecedentePerinatal){
            antecedentesperinatales=antecedenteperinatalService.findAntecedentePerinatalAll();
            if(antecedentesperinatales.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            antecedentesperinatales = Collections.singletonList(antecedenteperinatalService.getAntecedentePerinatal(UUID.fromString(idAntecedentePerinatal)));
        }
        return ResponseEntity.ok(antecedentesperinatales);
    }

    @PostMapping
    public ResponseEntity<AntecedentePerinatal> createAntecedentePerinatal(@Valid @RequestBody AntecedentePerinatal antecedenteperinatal, BindingResult result){
        antecedenteperinatal.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        AntecedentePerinatal antecedenteperinatalcreate = antecedenteperinatalService.createAntecedentePerinatal(antecedenteperinatal);
        return ResponseEntity.status(HttpStatus.CREATED).body(antecedenteperinatalcreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AntecedentePerinatal> updateAntecedentePerinatal(@PathVariable("id") String id, @RequestBody AntecedentePerinatal antecedenteperinatal){
        antecedenteperinatal.setId(UUID.fromString(id));
        AntecedentePerinatal antecedenteperinatalDB=antecedenteperinatalService.updateAntecedentePerinatal(antecedenteperinatal);
        if(antecedenteperinatalDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(antecedenteperinatalDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAntecedentePerinatal(@PathVariable("id") String id){
        String antecedenteperinatalDelete=antecedenteperinatalService.deleteAntecedentePerinatal(UUID.fromString(id));
        if(antecedenteperinatalDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(antecedenteperinatalDelete);
    }

    @Autowired
    ProducerService rabbitMQSender;
/*
    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new AntecedentePerinatal());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

 */



}
