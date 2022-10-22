package com.example.backpacientes.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = AntecedentePerinatal.class)
public class AntecedentePerinatal implements Serializable {

    @ApiModelProperty(value = "ID de la informacion adicional perinatal del paciente", dataType = "uuid", position = 1)
    @Id
    @Column("idantecedenteperinatal")
    @CassandraType(type = CassandraType.Name.UUID)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    private UUID id;

    /*@ApiModelProperty(value = "Es el apoyo familiar que tuvo el paciente al nacer - si/no", dataType = "bool", position = 2)
    @NotNull(message = "El apoyo familiar no puede ser nulo")
    @Column("apoyofam")
    @CassandraType(type = CassandraType.Name.BOOLEAN)
    private Boolean apoyofam;*/

    @ApiModelProperty(value = "Es el tipo de embarazo", dataType = "ascii", position = 2)
    @NotEmpty(message = "El tipo de embarazo no puede estar vacio")
    @NotNull(message = "El tipo de embarazo no puede ser nulo")
    @Column("tipoembarazo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String tipoembarazo;

    @ApiModelProperty(value = "Es el riesgo del embarazo", dataType = "ascii", position = 3)
    @NotEmpty(message = "El riesgo del embarazo no puede estar vacio")
    @NotNull(message = "El riesgo del embarazo no puede ser nulo")
    @Column("embarazoriesgo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String embarazoriesgo;

    @ApiModelProperty(value = "Es el control prenatal", dataType = "ascii", position = 4)
    @NotEmpty(message = "El control prenatal no puede estar vacio")
    @NotNull(message = "El control prenatal no puede ser nulo")
    @Column("controlprenatal")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String controlprenatal;

    @ApiModelProperty(value = "Es el número de embarazo de la paciente", dataType = "smallint", position = 5)
    @Range(min = 1, message = "El número de embarazo debe ser mayor que 0")
    @NotNull(message = "El número de embarazo no puede ser nulo")
    @Column("nroembarazo")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer nroembarazo;

    @ApiModelProperty(value = "Es la edad ---", dataType = "smallint", position = 6)
    @Range(min = 1, message = "La edad --- debe ser mayor que 0")
    @NotNull(message = "La edad --- no puede ser nulo")
    @Column("edadgestalnac")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer edadgestalnac;

    /*@ApiModelProperty(value = "Es la edad en la que la persona gestante dio a luz al paciente", dataType = "smallint", position = 7)
    @Range(min = 1, message = "La edad de la persona gestante debe ser mayor que 0")
    @NotNull(message = "La edad de la persona gestante no puede ser nulo")
    @Column("edadgestante")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer edadgestante;*/

    @ApiModelProperty(value = "Es el peso ---", dataType = "smallint", position = 8)
    @Range(min = 1, message = "El peso --- debe ser mayor que 0")
    @NotNull(message = "El peso --- no puede ser nulo")
    @Column("pesoalnac")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer pesoalnac;

    @ApiModelProperty(value = "Es la talla ---", dataType = "smallint", position = 9)
    @Range(min = 1, message = "La talla --- debe ser mayor que 0")
    @NotNull(message = "La talla --- no puede ser nulo")
    @Column("tallaalnac")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer tallaalnac;

    @ApiModelProperty(value = "---", dataType = "smallint", position = 10)
    @Range(min = 1, message = "--- debe ser mayor que 0")
    @NotNull(message = "--- no puede ser nulo")
    @Column("perimcefalico")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer perimcefalico;

    @ApiModelProperty(value = "---", dataType = "ascii", position = 11)
    @NotEmpty(message = "--- no puede estar vacio")
    @NotNull(message = "--- no puede ser nulo")
    @Column("respllanto")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String respllanto;

    /*@ApiModelProperty(value = "Es el numero de hijos que tiene quien dio a luz al paciente", dataType = "smallint", example = "0", position = 4)
    @Range(min = 0, message = "El numero de hijos no puede ser negativo")
    @NotNull(message = "El numero de hijos no puede ser nulo")
    @Column("nrohijos")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer nrohijos;*/

    /*@ApiModelProperty(value = "Es el espacio entre embarazos que tuvo quien dio a luz al paciente", dataType = "ascii", position = 5)
    @NotEmpty(message = "La espacio entre embarazos no puede ser vacio")
    @NotNull(message = "La espacio entre embarazos no puede ser nulo")
    @Column("embarazoespac")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String embarazoespac;*/

}
