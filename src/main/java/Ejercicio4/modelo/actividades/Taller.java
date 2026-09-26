package Ejercicio4.modelo.actividades;

import Ejercicio4.certificacion.Certificable;
import Ejercicio4.modelo.Estudiante;

import java.io.Serializable;

public class Taller extends Actividad implements Serializable, Certificable {

    private boolean requiereNetbook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNetbook) {
        super(id, titulo, cupoMaximo);
        this.requiereNetbook = requiereNetbook;
    }

    public boolean isRequiereNetbook() {
        return requiereNetbook;
    }

    @Override
    public double calcularCostoMateriales() {
        if (this.requiereNetbook) {
            return 5000.0;
        } else {
            return 2000.0;
        }
    }

    @Override
    public String getTipo() {
        return "Taller";
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "Certificado de curso para "+ estudiante.getNombre() + " en " + getTitulo() + " ("+ENTIDAD_EMISORA+")";
    }
}

