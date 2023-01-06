package com.sofka.trabajadores.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "trabajador")
public class Trabajador {

    @Id
    private String id = UUID.randomUUID().toString();

    private String nombre;

    private Integer edad;

    private Boolean activo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trabajador)) return false;
        Trabajador trabajador = (Trabajador) o;
        return Objects.equals(getId(), trabajador.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
