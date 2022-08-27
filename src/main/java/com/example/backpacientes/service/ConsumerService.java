package com.example.backpacientes.service;

import com.example.backpacientes.entity.Paciente;

import java.util.UUID;

public interface ConsumerService {
    Object consumerMessage(UUID proId) throws Exception;
}
