package Ejercicio4.modelo;

import Ejercicio4.excepciones.CupoExcedidoException;
import Ejercicio4.modelo.actividades.Charla;
import Ejercicio4.modelo.actividades.Curso;
import Ejercicio4.modelo.actividades.Taller;
import Ejercicio4.hilos.EnvioTicketsThread;

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
        listaEventos.add(evento1);
        EventoUniversitario evento2 = new EventoUniversitario("2", "Charlamos del futuro de la IA", 2000, false);
        listaEventos.add(evento2);
        EventoUniversitario evento3 = new EventoUniversitario("3", "Taller de programacion en papel", 3000, false);
        listaEventos.add(evento3);


        Sala sala1 = new Sala(1, "LISun");
        Sala sala2 = new Sala(2, "Salon");
        Sala sala3 = new Sala(3, "Aula 19");
        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);
        evento3.asignarSala(sala3);

        Curso curso = new Curso(1, "Charla de IA", 3, 2);
        Charla charla = new Charla(2, "Curso de JAVA", 3, "Santiago");
        Taller taller = new Taller(3, "Taller de programacion en papel", 3, true);

        evento1.agregarActividad(charla);
        evento2.agregarActividad(taller);
        evento3.agregarActividad(curso);

        //c y d
        try {
            Inscripcion ins1 = charla.inscribir(estudiante1);
            Inscripcion ins2 = curso.inscribir(estudiante2);
            Inscripcion ins3 = taller.inscribir(estudiante3);

            ins1.setEstado("Confirmada");
            ins1.setTicket(ins1.new TicketDeAcceso("Ticket 001"));

            ins2.setEstado("Confirmada");
            ins2.setTicket(ins2.new TicketDeAcceso("Ticket 002"));

            ins3.setEstado("Confirmada");
            ins3.setTicket(ins3.new TicketDeAcceso("Ticket 003"));

        } catch (CupoExcedidoException e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }


        //e
        for (Inscripcion ins : inscripciones) {
            if ("Confirmada".equals(ins.getEstado())) {
                ins.setTicket(ins.new TicketDeAcceso("Ticket " + ins.getEstudiante().getLegajo()));
            }
        }

        //f
        for (EventoUniversitario e : listaEventos) {
            EnvioTicketsThread hilo = new EnvioTicketsThread(e);
            hilo.start();
        }

        //g
        System.out.println("Datos del evento: ");
        for (EventoUniversitario event : listaEventos) {
            event.mostrarDatos();
        }

        //h
        for (EventoUniversitario event : listaEventos) {
            event.mostrarDatos();
        }



    }

}