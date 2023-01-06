package com.sofka.trabajadores.repository;

import com.sofka.trabajadores.model.Trabajador;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TrabajadorRepository extends ReactiveMongoRepository<Trabajador, String> {
}
