package com.example.backpacientes;

import com.example.backpacientes.config.CassandraConfig;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@EnableRabbit
@SpringBootApplication
public class BackPacientesApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackPacientesApplication.class, args);
    }

}

