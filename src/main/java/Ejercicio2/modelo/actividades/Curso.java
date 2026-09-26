package Ejercicio2.modelo.actividades;

import Ejercicio2.modelo.Estudiante;
import Ejercicio2.certificacion.Certificable;

public class Curso extends Actividad implements Certificable {

    private int nivel;


    public Curso(int nivel) {
        this.nivel = nivel;
    }

    public Curso(int id, String titulo, int cupoMaximo, int nivel) {
        super(id, titulo, cupoMaximo);
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public double calcularCostoMateriales() {
        return 0;
    }

    @Override
    public String getTipo() {
        return "Curso";
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Certificado de curso para "+ estudiante.getNombre() + " en " + getTitulo() + " ("+ENTIDAD_EMISORA+")";
    }
}
