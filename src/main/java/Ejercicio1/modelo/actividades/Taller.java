package Ejercicio1.modelo.actividades;

import java.io.Serializable;

public class Taller extends Actividad implements Serializable {

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

}

