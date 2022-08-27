package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.Paciente;
import com.example.backpacientes.service.ProducerService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProducerServiceImpl implements ProducerService {
     @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg(Paciente object) {
        amqpTemplate.convertSendAndReceive("salud.pacientes.exchange","salud.pacientes.routingkey",object);
    }
}
