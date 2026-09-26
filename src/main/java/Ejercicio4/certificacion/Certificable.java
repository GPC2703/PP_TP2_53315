package Ejercicio4.certificacion;

import Ejercicio4.modelo.Estudiante;

public interface Certificable {
    
    String ENTIDAD_EMISORA = "UTN";

   public String generarCertificado (Estudiante estudiante);
}
