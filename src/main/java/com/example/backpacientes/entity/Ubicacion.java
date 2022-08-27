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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Ubicacion.class)
public class Ubicacion  implements Serializable {

    @ApiModelProperty(value="ID de la ubicacion", dataType="uuid", position=1)
    @Id
    @Column("idubicacion")
    @CassandraType(type = CassandraType.Name.UUID)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKey
    private UUID id;

    @ApiModelProperty(value="El pais de la ubicacion", dataType="ascii", position=2)
    @NotEmpty(message = "El pais no puede ser vacio")
    @NotNull(message = "El pais no puede ser nulo")
    @Column("pais")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String pais;

    @ApiModelProperty(value="La region de la ubicacion", dataType="ascii", position=3)
    @NotEmpty(message = "La region no puede ser vacio")
    @NotNull(message = "La region no puede ser nulo")
    @Column("region")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String region;

    @ApiModelProperty(value="La provincia de la ubicacion", dataType="ascii", position=4)
    @NotEmpty(message = "La provincia no puede ser vacio")
    @NotNull(message = "La provincia no puede ser nulo")
    @Column( "provincia")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String provincia;

    @ApiModelProperty(value="El distrito de la ubicacion", dataType="ascii", position=5)
    @NotEmpty(message = "El distrito no puede ser vacio")
    @NotNull(message = "El distrito no puede ser nulo")
    @Column("distrito")
    @CassandraType(type = CassandraType.Name.ASCII)
    private String distrito;

    @ApiModelProperty(value="La direccion de la ubicacion", dataType="text", position=6)
    @NotEmpty(message = "La direccion no puede ser vacio")
    @NotNull(message = "La direccion no puede ser nulo")
    @Column("direccion")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String direccion;

}
