package Ejercicio1.modelo;

import Ejercicio1.excepciones.CupoExcedidoException;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;

    public Inscripcion(Estudiante estudiante, String estado) {
        this.fecha = LocalDate.now();
        this.estado = estado;
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", estudiante=" + estudiante +
                '}';
    }
}
