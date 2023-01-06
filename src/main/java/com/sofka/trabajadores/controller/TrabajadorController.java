package com.sofka.trabajadores.controller;

import com.sofka.trabajadores.model.Trabajador;
import com.sofka.trabajadores.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @PostMapping("/trabajador")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Trabajador> guardar(@RequestBody Trabajador trabajador) {
        return this.trabajadorService.guardar(trabajador);
    }


    @DeleteMapping("/borrar/{id}")
    private Mono<ResponseEntity<String>> borrar(@PathVariable("id") String id) {

        return this.trabajadorService.borrar(id)
                .flatMap(trabajador -> Mono.just(ResponseEntity
                        .ok("Trabajador eliminado")))
                .switchIfEmpty(Mono.just(ResponseEntity
                        .notFound().build()));
    }


    @DeleteMapping("/borrartodos")
    Mono<Void> borrarTodos() {
        return this.trabajadorService.borrarTodos();
    }


    @PutMapping("/actualizar/{id}")
    private Mono<ResponseEntity<Trabajador>> actualizar(@PathVariable("id") String id, @RequestBody Trabajador trabajador) {
        return this.trabajadorService.actualizar(id, trabajador)
                .flatMap(trabajador1 -> Mono.just(ResponseEntity
                        .ok(trabajador1))).switchIfEmpty(Mono
                        .just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/trabajadores")
    private Flux<Trabajador> listarTodos() {

        return this.trabajadorService.listarTodos();
    }

    @GetMapping("/listarid/{id}")
    private Mono<Trabajador> listarId(@PathVariable("id") String id) {
        return this.trabajadorService.listarId(id);
    }

    @GetMapping("/activos")
    private Flux<Trabajador> activo() {
        return this.trabajadorService.activo();
    }

}
