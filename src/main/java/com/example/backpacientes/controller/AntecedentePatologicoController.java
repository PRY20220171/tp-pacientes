package com.example.backpacientes.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backpacientes.entity.AntecedentePatologico;
import com.example.backpacientes.service.AntecedentePatologicoService;
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
@RequestMapping("/antecedentespatologicos")
public class AntecedentePatologicoController {
    @Autowired
    private AntecedentePatologicoService antecedentepatologicoService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de antecedentes patologicos por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=AntecedentePatologico.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<AntecedentePatologico>> listAntecedentePatologico(@RequestParam(name="idantecedentepatologico",required = false) String idAntecedentePatologico){
        List<AntecedentePatologico> antecedentespatologicos=new ArrayList<>();
        if(null==idAntecedentePatologico){
            antecedentespatologicos=antecedentepatologicoService.findAntecedentePatologicoAll();
            if(antecedentespatologicos.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            antecedentespatologicos = Collections.singletonList(antecedentepatologicoService.getAntecedentePatologico(UUID.fromString(idAntecedentePatologico)));
        }
        return ResponseEntity.ok(antecedentespatologicos);
    }

    @PostMapping
    public ResponseEntity<AntecedentePatologico> createAntecedentePatologico(@Valid @RequestBody AntecedentePatologico antecedentepatologico, BindingResult result){
        antecedentepatologico.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        AntecedentePatologico antecedentepatologicocreate = antecedentepatologicoService.createAntecedentePatologico(antecedentepatologico);
        return ResponseEntity.status(HttpStatus.CREATED).body(antecedentepatologicocreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AntecedentePatologico> updateAntecedentePatologico(@PathVariable("id") String id, @RequestBody AntecedentePatologico antecedentepatologico){
        antecedentepatologico.setId(UUID.fromString(id));
        AntecedentePatologico antecedentepatologicoDB=antecedentepatologicoService.updateAntecedentePatologico(antecedentepatologico);
        if(antecedentepatologicoDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(antecedentepatologicoDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAntecedentePatologico(@PathVariable("id") String id){
        String antecedentepatologicoDelete=antecedentepatologicoService.deleteAntecedentePatologico(UUID.fromString(id));
        if(antecedentepatologicoDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(antecedentepatologicoDelete);
    }

    /*
    @Autowired
    ProducerService rabbitMQSender;
    @GetMapping(value = "/test")
    public String producer() {
        rabbitMQSender.sendMsg(new AntecedentePatologico());
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

     */



}
