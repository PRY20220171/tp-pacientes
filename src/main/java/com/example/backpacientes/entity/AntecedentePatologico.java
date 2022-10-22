package com.example.backpacientes.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

//import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = AntecedentePatologico.class)
public class AntecedentePatologico implements Serializable {

    @ApiModelProperty(value = "ID de la informacion adicional patologica del paciente", dataType = "uuid", position = 1)
    @Id
    @Column("idantecedentepato")
    @CassandraType(type = CassandraType.Name.UUID)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value = "Es la informacion sobre si el paciente tuvo/tiene tuberculosis",
            dataType = "ascii", example = "Desconoce", position = 1)
    @NotEmpty(message = "La informacion sobre tuberculosis no puede ser vacio")
    @NotNull(message = "La informacion sobre tuberculosis no puede ser nulo")
    @Column("tbc")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String tbc;

    @ApiModelProperty(value = "Es la informacion sobre si el paciente tuvo/tiene SOBA/asma",
            dataType = "ascii", example = "Desconocido", position = 2)
    @NotEmpty(message = "La informacion sobre SOBA/asma no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre SOBA/asma no puede ser nulo")
    @Column("sobasma")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String sobasma;

    @ApiModelProperty(value = "Es la informacion sobre si el paciente tuvo alguna transferencia sanguinea",
            dataType = "ascii", example = "Desconocido", position = 3)
    @NotEmpty(message = "La informacion familiar sobre transferencia sanguinea no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre  transferencia sanguinea no puede ser nulo")
    @Column("transfsangre")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String transfsangre;

    @ApiModelProperty(value = "Es la informacion sobre si el paciente tuvo/tiene algun padecimiento neurologico",
            dataType = "ascii", example = "Desconocido", position = 4)
    @NotEmpty(message = "La informacion neurologica no puede ser vacio")
    @NotNull(message = "La informacion neurologica no puede ser nulo")
    @Column("neurologico")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String neurologico;

    @ApiModelProperty(value = "Es la informacion sobre si el paciente tuvo/tiene alergia a alguna medicina",
            dataType = "ascii", example = "Desconocido", position = 5)
    @NotEmpty(message = "La informacion sobre alergia a alguna medicina no puede ser vacio")
    @NotNull(message = "La informacion sobre alergia a alguna medicina no puede ser nulo")
    @Column("alergiamedic")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String alergiamedic;

    @ApiModelProperty(value = "Es la informacion sobre si el paciente tuvo/tiene otros antedecentes patologicos",
            dataType = "text", example = "Desconoce", position = 6)
    //@NotEmpty(message = "La informacion patológica adicional no puede ser vacio")
    //@NotNull(message = "La informacion patológica adicional no puede ser nulo")
    @Column("otros")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String otros;

}
