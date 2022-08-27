package com.example.backninos.entity;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Nino.class)
public class Nino  implements Serializable {

    @ApiModelProperty(value="ID de la informacion adicional del paciente como nino ", dataType="uuid", position=1)
    @Id
    @Column("idnino")
    @CassandraType(type = CassandraType.Name.UUID)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value="Es el tipo de embarazo - normal/complicado", dataType="ascii",example="normal", position=2)
    @NotEmpty(message = "El tipo de embarazo no puede ser vacio")
    @NotNull(message = "El tipo de embarazo no puede ser nulo")
    @Column("tipoembarazo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String tipoembarazo;

    @ApiModelProperty(value="Es el riesgo que tuvo el embarazo - si/no", dataType="ascii",example="no", position=3)
    @NotEmpty(message = "El riesgo que tuvo el embarazo no puede ser vacio")
    @NotNull(message = "El riesgo que tuvo el embarazo no puede ser nulo")
    @Column("embarazoriesgo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String embarazoriesgo;

    @ApiModelProperty(value="Es el control prenatal que tuvo el embarazo - si/no", dataType="ascii", position=4)
    @NotEmpty(message = "La control prenatal no puede ser vacio")
    @NotNull(message = "La control prenatal no puede ser nulo")
    @Column( "controlprenatal")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String controlprenatal;

    @ApiModelProperty(value="Es el numero de embarazo en el que nacio el paciente", dataType="smallint", example="1", position=5)
    @NotEmpty(message = "El numero de embarazo no puede ser vacio")
    @NotNull(message = "El numero de embarazo no puede ser nulo")
    @Column("nroembarazo")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer nroembarazo;

    @ApiModelProperty(value="Es la edad de gestacion en la que nacio el paciente (meses)", dataType="smallint", example="9", position=6)
    @NotEmpty(message = "La edad de gestacion no puede ser vacio")
    @NotNull(message = "La edad de gestacion no puede ser nulo")
    @Column("edadgestalnac")
    @CassandraType(type = CassandraType.Name.SMALLINT)
    private Integer edadgestalnac;

    @ApiModelProperty(value="Es peso del paciente al nacer", dataType="decimal", position=7)
    @NotEmpty(message = "El peso al nacer no puede ser vacio")
    @NotNull(message = "El peso al nacer no puede ser nulo")
    @Column( "pesoalnac")
    @CassandraType(type = CassandraType.Name.DECIMAL)
    private Float pesoalnac;

    @ApiModelProperty(value="Es la talla del paciente al nacer", dataType="decimal", position=8)
    @NotEmpty(message = "La talla al nacer no puede ser vacio")
    @NotNull(message = "La talla al nacer no puede ser nulo")
    @Column("tallaalnac")
    @CassandraType(type = CassandraType.Name.DECIMAL)
    private Float tallaalnac;

    @ApiModelProperty(value="Es el perimetro cefalico del paciente al nacer", dataType="decimal", position=9)
    @NotEmpty(message = "El perimetro cefalico al nacer no puede ser vacio")
    @NotNull(message = "El perimetro cefalico al nacer no puede ser nulo")
    @Column("perimcefalico")
    @CassandraType(type = CassandraType.Name.ASCII)
    private Float perimcefalico;

    @ApiModelProperty(value="Es la observacion sobre el llanto o la respiracion del paciente al nacer", dataType="ascii", position=10)
    @NotEmpty(message = "El llanto/respiracion al nacer no puede ser vacio")
    @NotNull(message = "El llanto/respiracion al nacer no puede ser nulo")
    @Column("respllanto")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String respllanto;
}
