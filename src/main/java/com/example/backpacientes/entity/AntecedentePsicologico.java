package com.example.backpacientes.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = AntecedentePsicologico.class)
public class AntecedentePsicologico implements Serializable {

    @ApiModelProperty(value = "ID de la informacion psicológica del paciente", dataType = "uuid", position = 1)
    @Id
    @Column("idantecedentepsico")
    @CassandraType(type = CassandraType.Name.UUID)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value = "Es el apoyo familiar que tuvo el paciente al nacer - si/no", dataType = "bool", position = 2)
    @NotNull(message = "El apoyo familiar no puede ser nulo")
    @Column("apoyofam")
    @CassandraType(type = CassandraType.Name.BOOLEAN)
    private Boolean apoyofam;

    @ApiModelProperty(value = "Es la edad ---", dataType = "smallint", position = 3)
    @Range(min = 1, message = "La edad --- debe ser mayor que 0")
    @NotNull(message = "La edad --- no puede ser nulo")
    @Column("edadgestante")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer edadgestante;

    @ApiModelProperty(value = "Es el numero de hijos que tiene quien dio a luz al paciente", dataType = "smallint", example = "0", position = 4)
    @Range(min = 0, message = "El numero de hijos no puede ser negativo")
    @NotNull(message = "El numero de hijos no puede ser nulo")
    @Column("nrohijos")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer nrohijos;

    @ApiModelProperty(value = "Es el espacio entre embarazos que tuvo quien dio a luz al paciente", dataType = "ascii", position = 5)
    @NotEmpty(message = "El espacio entre embarazos no puede estar vacio")
    @NotNull(message = "El espacio entre embarazos no puede ser nulo")
    @Column("embarazoespac")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String embarazoespac;

    @ApiModelProperty(value = "Es el tipo de trabajo ---", dataType = "ascii", position = 6)
    @NotEmpty(message = "El tipo de trabajo no puede estar vacio")
    @NotNull(message = "El tipo de trabajo no puede ser nulo")
    @Column("tipotrabajo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String tipotrabajo;

    @ApiModelProperty(value = "Es el tipo de trabajo ---", dataType = "ascii", position = 7)
    @NotEmpty(message = "El tipo de trabajo no puede estar vacio")
    @NotNull(message = "El tipo de trabajo no puede ser nulo")
    @Column("violenciaocupacional")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String violenciaocupacional;

    @ApiModelProperty(value = "Es la vida social ---", dataType = "ascii", position = 8)
    @NotEmpty(message = "La vida social no puede estar vacia")
    @NotNull(message = "La vida social no puede ser nula")
    @Column("vidasocial")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String vidasocial;

    @ApiModelProperty(value = "Es la informacion si pertenece a una organizacion ---", dataType = "ascii", position = 9)
    @NotEmpty(message = "La informacion sobre si pertenece a una organizacion no puede estar vacia")
    @NotNull(message = "La informacion sobre si pertenece a una organizacion no puede ser nula")
    @Column("perteneceorg")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String perteneceorg;

}
