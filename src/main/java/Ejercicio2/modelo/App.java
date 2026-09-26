package Ejercicio2.modelo;

import Ejercicio2.excepciones.CupoExcedidoException;
import Ejercicio2.modelo.actividades.Actividad;
import Ejercicio2.modelo.actividades.Charla;
import Ejercicio2.modelo.actividades.Curso;
import Ejercicio2.modelo.actividades.Taller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<EventoUniversitario> listaEventos = new ArrayList<EventoUniversitario>();
    public static List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    public static List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
    public static List<String> certificados = new ArrayList<>();


    public static void main(String[] args) throws CupoExcedidoException {

        //a
        Estudiante estudiante1 = new Estudiante("53145", "Laura");
        Estudiante estudiante2 = new Estudiante("54321", "Jorge");
        Estudiante estudiante3 = new Estudiante("54677", "Juan");

        //b
        System.out.println("Creando eventos...");
        EventoUniversitario evento1 = new EventoUniversitario("1", "Curso de JAVA", 5000, false);
        EventoUniversitario evento2 = new EventoUniversitario("2", "Charlamos del futuro de la IA", 2000, false);
        EventoUniversitario evento3 = new EventoUniversitario("3", "Taller de programacion en papel", 3000, false);

        //c
        Sala sala1 = new Sala(1, "LISun");
        Sala sala2 = new Sala(2, "Salon");
        Sala sala3 = new Sala(3, "Aula 19");
        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);
        evento3.asignarSala(sala3);

        //d
        Curso curso = new Curso(1, "Charla de IA", 3, 2);
        Charla charla = new Charla(2, "Curso de JAVA", 3, "Santiago");
        Taller taller = new Taller(3, "Taller de programacion en papel", 3, true);

        evento1.agregarActividad(charla);
        evento2.agregarActividad(taller);
        evento3.agregarActividad(curso);

        //e
        try {
            Inscripcion ins1 = charla.inscribir(estudiante1);
            Inscripcion ins2 = curso.inscribir(estudiante2);
            Inscripcion ins3 = taller.inscribir(estudiante3);
        } catch (CupoExcedidoException e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }


        //f
        curso.generarCertificado(estudiante1);
        taller.generarCertificado(estudiante3);

        //g
        certificados.add(curso.generarCertificado(estudiante1));
        certificados.add(taller.generarCertificado(estudiante3));
        System.out.println("Certificados emitidos");
        for (String certificado : certificados) {
            System.out.println(certificado);
        }

        //h
        evento1.mostrarDatos();
        evento2.mostrarDatos();
        evento3.mostrarDatos();

        


    }

}