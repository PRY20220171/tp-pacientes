package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.Paciente;
import com.example.backpacientes.service.ProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private Environment environment;
    @Autowired
    private DirectExchange exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Paciente sendMsg(String idPaciente) {
        try{
            Object response = amqpTemplate.convertSendAndReceive(exchange.getName(), routingkey, idPaciente);

            if(response!=null){
                return objectMapper.readValue(response.toString(), Paciente.class);
            }
            else{
                return null;
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
            return null;
        }
    }
    /*
    @Override
    public void sendMsg(Paciente object) {
        amqpTemplate.convertSendAndReceive(environment.getProperty("${salud.pacientes.exchange}") ,environment.getProperty("${salud.pacientes.routingkey}"),object);
    }

 */
}
