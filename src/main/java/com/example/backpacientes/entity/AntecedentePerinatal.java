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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = AntecedentePerinatal.class)
public class AntecedentePerinatal implements Serializable {

    @ApiModelProperty(value="ID de la informacion adicional perinatal del paciente", dataType="uuid", position=1)
    @Id
    @Column("idantecedenteperinatal")
    @CassandraType(type = CassandraType.Name.UUID)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value="Es el apoyo familiar que tuvo el paciente al nacer - si/no", dataType="bool", position=2)
    @NotEmpty(message = "El apoyo familiar no puede ser vacio")
    @NotNull(message = "El apoyo familiar no puede ser nulo")
    @Column("apoyofam")
    @CassandraType(type = CassandraType.Name.BOOLEAN)
    private Boolean apoyofam;

    @ApiModelProperty(value="Es la edad en la que la persona gestante dio a luz al paciente", dataType="smallint", position=3)
    @NotEmpty(message = "La edad de la persona gestante no puede ser vacio")
    @NotNull(message = "La edad de la persona gestante no puede ser nulo")
    @Column("edadgestante")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer edadgestante;

    @ApiModelProperty(value="Es el numero de hijos que tiene quien dio a luz al paciente", dataType="smallint", example="0", position=4)
    @NotEmpty(message = "El numero de hijos no puede ser vacio")
    @NotNull(message = "El numero de hijos no puede ser nulo")
    @Column("nrohijos")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer nrohijos;

    @ApiModelProperty(value="Es el espacio entre embarazos que tuvo quien dio a luz al paciente", dataType="ascii", position=5)
    @NotEmpty(message = "La espacio entre embarazos no puede ser vacio")
    @NotNull(message = "La espacio entre embarazos no puede ser nulo")
    @Column("embarazoespac")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String embarazoespac;

}
