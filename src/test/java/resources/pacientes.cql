create table paciente
(
    id               uuid primary key,
    apellidos        ascii,
    docnum           ascii,
    doctipo          ascii,
    estadocivil      text,
    gradoinstruccion ascii,
    gruposang        ascii,
    nombres          ascii,
    ocupacion        text,
    rh               ascii,
    sexo             ascii,
    telefono         ascii
);

--INSERT INTO pacientes.paciente (id, apellidos, docnum, doctipo, estadocivil, gradoinstruccion, gruposang, nombres, ocupacion, rh, sexo, telefono)
--VALUES (0155c660-281b-11ed-9fef-3935c9454cdd, 'apellidoprueba', '78945632', 'dni', 'estado civil de prueba', 'instruccion de prueba', 'ab', 'nombreprueba', 'ocupacion de prueba', '+', 'm', '1231231');
