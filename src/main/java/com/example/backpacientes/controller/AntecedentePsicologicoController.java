package com.example.backpacientes.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.backpacientes.entity.AntecedentePsicologico;
import com.example.backpacientes.entity.AntecedentePsicologico;
import com.example.backpacientes.service.AntecedentePsicologicoService;
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
@RequestMapping("/antecedentespsicologicos")
public class AntecedentePsicologicoController {

    @Autowired
    private AntecedentePsicologicoService antecedentePsicologicoService;

    @ApiOperation(value = "Obtener un antecedente psicológico por su ID", notes = "Provee un mecanismo para obtener todos los datos de antecedente psicológico por su ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = AntecedentePsicologico.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class)
    })
    @GetMapping
    public ResponseEntity<List<AntecedentePsicologico>> listAntecedentePsicologico(@RequestParam(name = "idantecedentepsicologico", required = false) String idAntecedentePsicologico) {

        List<AntecedentePsicologico> antecedentesPsicologicos = new ArrayList<>();

        if (null == idAntecedentePsicologico) {
            antecedentesPsicologicos = antecedentePsicologicoService.findAntecedentePsicologicoAll();
            if (antecedentesPsicologicos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            antecedentesPsicologicos = Collections.singletonList(antecedentePsicologicoService.getAntecedentePsicologico(UUID.fromString(idAntecedentePsicologico)));
        }

        return ResponseEntity.ok(antecedentesPsicologicos);

    }

    @PostMapping
    public ResponseEntity<AntecedentePsicologico> createAntecedentePsicologico(@Valid @RequestBody AntecedentePsicologico antecedentePsicologico, BindingResult result) {

        antecedentePsicologico.setId(Uuids.timeBased());

        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Message.formatMessage(result));
        }

        AntecedentePsicologico antecedentePsicologicoCreate = antecedentePsicologicoService.createAntecedentePsicologico(antecedentePsicologico);
        return ResponseEntity.status(HttpStatus.CREATED).body(antecedentePsicologicoCreate);

    }

    @PutMapping("/{id}")
    public ResponseEntity<AntecedentePsicologico> updateAntecedentePsicologico(@PathVariable("id") String id, @RequestBody AntecedentePsicologico antecedentePsicologico) {

        antecedentePsicologico.setId(UUID.fromString(id));
        AntecedentePsicologico antecedentePsicologicoDB = antecedentePsicologicoService.updateAntecedentePsicologico(antecedentePsicologico);

        if (antecedentePsicologicoDB == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(antecedentePsicologicoDB);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAntecedentePsicologico(@PathVariable("id") String id) {

        String antecedentePsicologicoDelete = antecedentePsicologicoService.deleteAntecedentePsicologico(UUID.fromString(id));

        if (antecedentePsicologicoDelete == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(antecedentePsicologicoDelete);

    }

}
