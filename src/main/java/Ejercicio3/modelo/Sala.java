package Ejercicio3.modelo;

import java.io.Serializable;

public class Sala implements Serializable {
    int id;
    String nombre;

    public Sala(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
