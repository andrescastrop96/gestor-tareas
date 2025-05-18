package com.tareas.gestor.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subtareas")
public class Subtarea {

    @EmbeddedId
    private SubtareaPK id;

    private String nombre;
    private Boolean completada;

    @ManyToOne
    @MapsId("idTarea") // <-- mapea el campo idTarea del PK compuesto
    @JoinColumn(name = "id_tarea")
    private Tareas tarea;

    public SubtareaPK getId() {
        return id;
    }

    public void setId(SubtareaPK id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }
}
