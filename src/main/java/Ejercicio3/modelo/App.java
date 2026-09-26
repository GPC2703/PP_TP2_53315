package Ejercicio3.modelo;

import Ejercicio3.excepciones.CupoExcedidoException;
import Ejercicio3.modelo.actividades.Actividad;
import Ejercicio3.modelo.actividades.Charla;
import Ejercicio3.modelo.actividades.Curso;
import Ejercicio3.modelo.actividades.Taller;

import java.sql.SQLOutput;
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

        //c
        try {
            Inscripcion ins1 = charla.inscribir(estudiante1);
            Inscripcion ins2 = curso.inscribir(estudiante2);
            Inscripcion ins3 = taller.inscribir(estudiante3);
        } catch (CupoExcedidoException e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }


        //d y e
        for (EventoUniversitario event : listaEventos){
            List<Charla> charlas = event.filtrarActividadesPorTipo(Charla.class);
            System.out.println("Cantidad de charlas del evento "+event+" : "+charlas.size());
            List<Curso> cursos = event.filtrarActividadesPorTipo(Curso.class);
            System.out.println("Cantidad de cursos del evento "+event+" : "+cursos.size());
            List<Taller> talleres = event.filtrarActividadesPorTipo(Taller.class);
            System.out.println("Cantidad de talleres del evento "+event+" : "+talleres.size());

            //f
            double costoCharlas = event.calcularCostoMateriales(charlas);
            System.out.println("Costo de materiales de charlas: "+ costoCharlas);

            double costoCursos = event.calcularCostoMateriales(cursos);
            System.out.println("Costo de materiales de cursos: "+ costoCursos);

            double costoTalleres = event.calcularCostoMateriales(talleres);
            System.out.println("Costo de materiales de talleres: "+ costoTalleres);

            //g
            for (Charla cha : charlas){
                System.out.println("Disertante de la charla: "+ cha.getDisertante());
            }
            for (Taller tal: talleres){
                System.out.println("Requiere netbook: "+ tal.isRequiereNetbook());
            }
            for (Curso cur : cursos){
                System.out.println("Nivel de curso: "+ cur.getNivel());
            }
            System.out.println("Recorrido de evento finalizo");
            System.out.println("--------- Evento Nuevo ---------");

        }



    }

}