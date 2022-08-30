package com.example.backpacientes.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backpacientes.entity.Paciente;
import com.example.backpacientes.service.PacienteService;
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
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @ApiOperation(value="Obtener un producto por su ID", notes="Provee un mecanismo para obtener todos los datos de un paciente por su ID")
    @ApiResponses(value= {
            @ApiResponse(code=200, message="OK", response=Paciente.class),
            @ApiResponse(code=404, message="Not Found", response= ErrorMessage.class),
            @ApiResponse(code=500, message="Internal Server Error", response=ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<Paciente>> listPaciente(@RequestParam(name="idpaciente",required = false) String idPaciente){
        List<Paciente> pacientes=new ArrayList<>();
        if(null==idPaciente){
            pacientes=pacienteService.findPacienteAll();
            if(pacientes.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        else{
            pacientes = Collections.singletonList(pacienteService.getPaciente(UUID.fromString(idPaciente)));
        }
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@Valid @RequestBody Paciente paciente, BindingResult result){
        paciente.setId(Uuids.timeBased());
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }
        Paciente pacientecreate = pacienteService.createPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacientecreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable("id") String id, @RequestBody Paciente paciente){
        paciente.setId(UUID.fromString(id));
        Paciente pacienteDB=pacienteService.updatePaciente(paciente);
        if(pacienteDB==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pacienteDB);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable("id") String id){
        String pacienteDelete=pacienteService.deletePaciente(UUID.fromString(id));
        if(pacienteDelete==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pacienteDelete);
    }

    @Autowired
    ProducerService rabbitMQSender;

    @GetMapping(value = "/test/{id}")
    public ResponseEntity<Paciente> producer(@PathVariable("id") String id) {
        Paciente paciente = rabbitMQSender.sendMsg(id);
        if(paciente==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }

}
