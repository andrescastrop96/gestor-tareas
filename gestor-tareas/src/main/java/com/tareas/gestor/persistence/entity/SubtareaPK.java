package com.tareas.gestor.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubtareaPK implements Serializable {

    @Column(name = "id_tarea")
    private Integer idTarea;

    @Column(name = "id_subtarea")
    private Integer idSubtarea;

    public SubtareaPK() {}

    public SubtareaPK(Integer idTarea, Integer idSubtarea) {
        this.idTarea = idTarea;
        this.idSubtarea = idSubtarea;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getIdSubtarea() {
        return idSubtarea;
    }

    public void setIdSubtarea(Integer idSubtarea) {
        this.idSubtarea = idSubtarea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubtareaPK)) return false;
        SubtareaPK that = (SubtareaPK) o;
        return Objects.equals(idTarea, that.idTarea) &&
                Objects.equals(idSubtarea, that.idSubtarea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarea, idSubtarea);
    }
}
