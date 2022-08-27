package com.example.backubicacions.entity;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = AntecedenteFamiliar.class)
public class AntecedenteFamiliar  implements Serializable {

    @ApiModelProperty(value="ID de la ubicacion", dataType="uuid", position=1)
    @Id
    @Column("idantecedentefam")
    @CassandraType(type = CassandraType.Name.UUID)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente tuvo/tiene tuberculosis", 
        dataType="ascii", example="Desconoce", position=1)
    @NotEmpty(message = "La informacion familiar sobre tuberculosis no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre tuberculosis no puede ser nulo")
    @Column("tbc")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String tbc;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente tuvo/tiene VIH/SIDA", 
        dataType="ascii", example="Desconocido", position=2)
    @NotEmpty(message = "La informacion familiar sobre VIH/SIDA no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre VIH/SIDA no puede ser nulo")
    @Column("vihsida")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String vihsida;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente tuvo/tiene diabetes", 
        dataType="ascii", example="Desconocido", position=3)
    @NotEmpty(message = "La informacion familiar sobre diabetes no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre diabetes no puede ser nulo")
    @Column( "diabetes")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String diabetes;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente tuvo/tiene epilepsia",
        dataType="ascii", example="Desconocido", position=4)
    @NotEmpty(message = "La informacion familiar sobre epilepsia no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre epilepsia no puede ser nulo")
    @Column("epilepsia")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String epilepsia;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente tuvo/tiene alergia a alguna medicina",
        dataType="ascii", example="Desconocido", position=5)
    @NotEmpty(message = "La informacion familiar sobre alergia a alguna medicina no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre alergia a alguna medicina no puede ser nulo")
    @Column("alergiamedic")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String alergiamedic;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente tuvo/tiene sufre de violencia familiar", 
        dataType="ascii", example="Desconoce", position=6)
    @NotEmpty(message = "La informacion familiar sobre violencia familiar no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre violencia familiar no puede ser nulo")
    @Column("violenciafam")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String violenciafam;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente fue/es alcoholico", 
        dataType="ascii", example="Desconocido", position=7)
    @NotEmpty(message = "La informacion familiar sobre alcoholismo no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre alcoholismo no puede ser nulo")
    @Column("alcoholismo")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String alcoholismo;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente consumía/consume drogas", 
        dataType="ascii", example="Desconocido", position=8)
    @NotEmpty(message = "La informacion familiar sobre drogradiccion no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre drogradiccion no puede ser nulo")
    @Column( "drogradiccion")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String drogradiccion;

    @ApiModelProperty(value="Es la informacion sobre si un familiar del paciente tuvo/tiene hepatitis B",
        dataType="ascii", example="Desconocido", position=9)
    @NotEmpty(message = "La informacion familiar sobre hepatitis B no puede ser vacio")
    @NotNull(message = "La informacion familiar sobre hepatitis B no puede ser nulo")
    @Column("hepatitisb")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String hepatitisb;

}
