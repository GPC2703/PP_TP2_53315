package Ejercicio4.modelo.actividades;

import Ejercicio4.excepciones.CupoExcedidoException;
import Ejercicio4.modelo.Estudiante;
import Ejercicio4.modelo.Inscripcion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad implements Serializable {
    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int CUPO_MINIMO = 5;
    private List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

    public Actividad() {

    }

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }

    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException {
        if (this.inscripciones.size() >= this.cupoMaximo){
            throw new CupoExcedidoException("Se alcanzo el cupo maximo, el cual es: "+ this.cupoMaximo);
        }
        Inscripcion nuevaInscripcion = new Inscripcion(estudiante, "Confirmado");
        this.inscripciones.add(nuevaInscripcion);
        return nuevaInscripcion;


    }

    public void mostrarInscripciones() {
        for (Inscripcion ins : this.inscripciones) {
            System.out.println(ins);
        }
    }

    public final void mostrarIdentificacion() {
        System.out.println("ID: " + id + " | Título: " + titulo + " | Tipo: " + getTipo());
    }


    public abstract double calcularCostoMateriales();

    public abstract String getTipo();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", cupoMaximo=" + cupoMaximo +
                ", inscripciones=" + inscripciones +
                '}';
    }
}

