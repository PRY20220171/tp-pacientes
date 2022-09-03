package com.example.backpacientes.service;

import com.example.backpacientes.entity.Paciente;

public interface ProducerService {
    //Object sendMsg(Long proId) throws Exception;
    Paciente sendMsg(String idPaciente);
    //void sendMsg(Paciente object);
}
