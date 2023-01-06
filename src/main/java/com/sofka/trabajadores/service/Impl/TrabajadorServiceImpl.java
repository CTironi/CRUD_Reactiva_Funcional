package com.sofka.trabajadores.service.Impl;

import com.sofka.trabajadores.model.Trabajador;
import com.sofka.trabajadores.repository.TrabajadorRepository;
import com.sofka.trabajadores.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public Mono<Trabajador> guardar(Trabajador trabajador) {
        return this.trabajadorRepository.save(trabajador);
    }

    @Override
    public Mono<Trabajador> borrar(String id) {
        return this.trabajadorRepository
                .findById(id)
                .flatMap(p -> this.trabajadorRepository
                        .deleteById(p.getId())
                        .thenReturn(p));
    }

    @Override
    public Mono<Trabajador> actualizar(String id, Trabajador trabajador) {
        return this.trabajadorRepository
                .findById(id)
                .flatMap(m -> {
                    m.setId(id);
                    m.setNombre(trabajador.getNombre());
                    m.setEdad(trabajador.getEdad());
                    m.setActivo(trabajador.getActivo());
                    return guardar(m);
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Trabajador> listarTodos() {
        return trabajadorRepository.findAll();
    }

    @Override
    public Mono<Trabajador> listarId(String id) {
        return this.trabajadorRepository.findById(id);
    }

    @Override
    public Mono<Void> borrarTodos() {
        return this.trabajadorRepository.deleteAll();
    }

    @Override
    public Flux<Trabajador> activo() {
        return this.trabajadorRepository
                .findAll()
                .filter(trabajador -> trabajador.getActivo().equals(true));
    }
}
