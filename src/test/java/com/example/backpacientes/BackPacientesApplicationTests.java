package com.example.backpacientes;

import com.example.backpacientes.config.CassandraConfig;
import com.example.backpacientes.entity.Paciente;
import com.example.backpacientes.repository.PacienteRepository;
import com.example.backpacientes.service.PacienteService;
import com.example.backpacientes.service.impl.PacienteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CassandraConfig.class})

public class BackPacientesApplicationTests {
    @Mock
    private PacienteRepository pacienteRepository;
    @InjectMocks
    private PacienteService pacienteService = new PacienteServiceImpl();
    Paciente pacienteprueba = new Paciente();
    @Before
    public void setUp(){

        pacienteprueba.setId(UUID.randomUUID());
        pacienteprueba.setNombres("Alexis Enrique");
        pacienteprueba.setApellidos("Barrios Perez");
        pacienteprueba.setDocnum("12345678");
        pacienteprueba.setDoctipo("dni");
        pacienteprueba.setSexo("masculino");
        pacienteprueba.setGruposang("AB");
        pacienteprueba.setRh("+");
        pacienteprueba.setTelefono("123456789");
        pacienteprueba.setGradoinstruccion("universitario");
        pacienteprueba.setEstadocivil("soltero");
        //when(pacienteRepository.save(null)).thenReturn(null);
        when(pacienteRepository.save(any(Paciente.class))).thenAnswer(i -> i.getArguments()[0]);
    }
    @Test
    public void contextLoads() throws Exception{
        String methodName = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
        Paciente aux = pacienteService.createPaciente(null);
        Assertions.assertNull(aux);
        aux = pacienteService.createPaciente(pacienteprueba);
        System.out.println(pacienteprueba.getId());
        System.out.println(aux);
        AssertUtil.assertNotNull(methodName + " - NULL TEST",aux);
    }

}
