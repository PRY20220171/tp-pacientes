package com.example.backpacientes.service;

import com.example.backpacientes.entity.Paciente;

public interface ProducerService {
    //Object sendMsg(Long proId) throws Exception;

    void sendMsg(Paciente object);
}
