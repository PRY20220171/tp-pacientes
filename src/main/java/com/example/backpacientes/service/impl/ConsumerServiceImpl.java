package com.example.backpacientes.service.impl;

import com.example.backpacientes.entity.Paciente;
import com.example.backpacientes.service.ConsumerService;
import com.example.backpacientes.service.PacienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpIOException;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private PacienteService pacienteService;

    @Override
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "${spring.rabbitmq.queue}",durable = "true"),
                    exchange = @Exchange(value = "${spring.rabbitmq.exchange}"),
                    key = "${spring.rabbitmq.routingkey}")
    )
    //@RabbitListener(queues = "${spring.rabbitmq.queue}")
    //@SendTo("amq.rabbitmq.reply-to")
    public Object consumerMessage(String objId) throws AmqpIOException {
        System.out.println("=============== Message ==================");
        System.out.println(objId);
        System.out.println("==========================================");
        UUID pacienteId;
        try{
            pacienteId= UUID.fromString(objId);
        } catch (Exception e) {
            ObjectMapper obj = new ObjectMapper();
            try {
                return obj.writeValueAsString("Error: El id del paciente no es un UUID válido");
            }catch(JsonProcessingException ex){
                return null;
            }
        }
        //System.out.println("UUID VALIDATED");
        //System.out.println(pacienteId);
        Paciente product= pacienteService.getPaciente(pacienteId);
        //System.out.println("PACIENTE OBTENIDO");
        if(product==null){
            System.out.println("No existe el paciente");
            return null;
        }
        else{
            System.out.println("Existe el paciente");
            ObjectMapper obj = new ObjectMapper();
            try {
                //return product;
                return obj.writeValueAsString(product);
            }catch(JsonProcessingException e){
                return null;
            }
        }
    }
}