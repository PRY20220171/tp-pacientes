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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Paciente.class)
public class Paciente  implements Serializable {
    
    @ApiModelProperty(value="ID del paciente", dataType="uuid", position=1)
    @Id
    @Column("idpaciente")
    @CassandraType(type = CassandraType.Name.UUID)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value="Los nombres del paciente", dataType="ascii", position=2)
    @NotEmpty(message = "Los nombres no pueden ser vacios")
    @NotNull(message = "Los nombres no pueden ser nulos")
    @Column("nombres")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String nombres;
    
    @ApiModelProperty(value="Los apellidos del paciente", dataType="ascii", position=3)
    @NotEmpty(message = "Los apellidos no pueden ser vacios")
    @NotNull(message = "Los apellidos no pueden ser nulos")
    @Column("apellidos")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String apellidos;

    @ApiModelProperty(value="El número de identificación del paciente", dataType="ascii", position=4)
    @NotEmpty(message = "El número de identificación no puede ser vacio")
    @NotNull(message = "El número de identificación no puede ser nulo")
    @Column("docnum")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String docnum;

    @ApiModelProperty(value="El tipo de documento del paciente", dataType="ascii", position=5)
    @NotEmpty(message = "El tipo de documento no puede ser vacio")
    @NotNull(message = "El tipo de documento no puede ser nulo")
    @Column("doctipo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String doctipo;

    @ApiModelProperty(value="El sexo del paciente", dataType="ascii", position=6)
    @NotEmpty(message = "El sexo no puede ser vacio")
    @NotNull(message = "El sexo no puede ser nulo")
    @Column("sexo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String sexo;

    //private Date fecnac;
    @ApiModelProperty(value="El grupo sanguineo del paciente", dataType="ascii", position=7)
    @NotEmpty(message = "El grupo sanguineo no puede ser vacio")
    @NotNull(message = "El grupo sanguineo no puede ser nulo")
    @Column( "gruposang")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String gruposang;
    
    @ApiModelProperty(value="El factor rh de sangre del paciente", dataType="ascii", position=8)
    @NotEmpty(message = "El factor rh no puede ser vacio")
    @NotNull(message = "El factor rh no puede ser nulo")
    @Column("rh")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String rh;
    
    @ApiModelProperty(value="El telefono del paciente", dataType="ascii", position=9)
    @NotEmpty(message = "El telefono no puede ser vacio")
    @NotNull(message = "El telefono no puede ser nulo")
    @Column("telefono")
    @CassandraType(type = CassandraType.Name.ASCII)
    
    private String telefono;
    @ApiModelProperty(value="El grado de instruccion del paciente", dataType="ascii", position=10)
    @NotEmpty(message = "El grado de instruccion no puede ser vacio")
    @NotNull(message = "El grado de instruccion no puede ser nulo")
    @Column("gradoinstruccion")
    @CassandraType(type = CassandraType.Name.ASCII)
    
    private String gradoinstruccion;
    @ApiModelProperty(value="La ocupación del paciente", dataType="text", position=11)
    @NotEmpty(message = "La ocupación no puede ser vacio")
    @NotNull(message = "La ocupación no puede ser nulo")
    @Column("ocupacion")
    @CassandraType(type = CassandraType.Name.TEXT)
    
    private String ocupacion;
    @ApiModelProperty(value="El estado civil del paciente", dataType="text", position=12)
    @NotEmpty(message = "El estado civil no puede ser vacio")
    @NotNull(message = "No estado civil no puede ser nulo")
    @Column("estadocivil")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String estadocivil;

    //private Long lugarnac;
    //private Long domicilioact;
    //private Long idnino;
    //private Long idadultomayor;
    //private Long idantecedenteperi;
    //private Long idantecedentefam;
    //private Long idantecedentepato;
    //private Long idubicacion;

}
