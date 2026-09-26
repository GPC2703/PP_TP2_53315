package Ejercicio2.certificacion;

import Ejercicio2.modelo.Estudiante;

public interface Certificable {
    
    String ENTIDAD_EMISORA = "UTN";

   public String generarCertificado (Estudiante estudiante);
}
