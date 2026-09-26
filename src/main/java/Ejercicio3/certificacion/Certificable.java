package Ejercicio3.certificacion;

import Ejercicio3.modelo.Estudiante;

public interface Certificable {
    
    String ENTIDAD_EMISORA = "UTN";

   public String generarCertificado (Estudiante estudiante);
}
