package com.sofka.trabajadores.service;

import com.sofka.trabajadores.model.Trabajador;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TrabajadorService {

    Mono<Trabajador> guardar(Trabajador trabajador);

    Mono<Trabajador> borrar(String id);

    Mono<Trabajador> actualizar(String id, Trabajador trabajador);

    Flux<Trabajador> listarTodos();

    Mono<Trabajador> listarId(String id);

    Mono<Void> borrarTodos();

    Flux<Trabajador> activo();
}
