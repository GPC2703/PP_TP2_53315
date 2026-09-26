package Ejercicio3.modelo.actividades;

import Ejercicio3.certificacion.Certificable;
import Ejercicio3.modelo.Estudiante;

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
        if (this.nivel > 2) {
            return 6000.0;
        } else {
            return 3000.0;
        }
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
