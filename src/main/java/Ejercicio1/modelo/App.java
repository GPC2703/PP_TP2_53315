package Ejercicio1.modelo;

import Ejercicio1.excepciones.CupoExcedidoException;
import Ejercicio1.modelo.actividades.Actividad;
import Ejercicio1.modelo.actividades.Charla;
import Ejercicio1.modelo.actividades.Taller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<EventoUniversitario> listaEventos = new ArrayList<EventoUniversitario>();
    public static List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    public static List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();


    public static void main(String[] args) throws CupoExcedidoException {

        Estudiante estudiante1 = new Estudiante("53145", "Laura");
        Estudiante estudiante2 = new Estudiante("54321", "Jorge");
        Estudiante estudiante3 = new Estudiante("54677", "Juan");

        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);


        System.out.println("Creando eventos...");
        EventoUniversitario evento1 = new EventoUniversitario("27", "Baile", 5000, false);
        listaEventos.add(evento1);

        Sala sala1 = new Sala(1,"Salon de Baile");
        evento1.asignarSala(sala1);

        Charla charla1 = new Charla(1, "Danza Contemporánea", 1, "Laura");
        Taller taller1 = new Taller(2, "Taller de Baile", 1, true);
        evento1.agregarActividad(charla1);
        evento1.agregarActividad(taller1);

        //a
        try {
            Inscripcion ins1 = charla1.inscribir(estudiante1);
            Inscripcion ins2 = charla1.inscribir(estudiante2);
        } catch (CupoExcedidoException e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }

        try{
            Inscripcion ins3 = taller1.inscribir(estudiante2);
            Inscripcion ins4 = taller1.inscribir(estudiante3);
        } catch (CupoExcedidoException e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }

        //b
        try {
            FileOutputStream fos = new FileOutputStream("evento1.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(evento1);
            oos.close();
        //c
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se ha encontrado");
        } catch (IOException e) {
            System.out.println("Se produjo un error de E/S");
        }

        //d y e
        try {
            EventoUniversitario evento3 = new EventoUniversitario("3", "Baile", 5000, false);
            Charla charla2 = new Charla(2, "Bachata", 2, "Daniela");
            Inscripcion ins = charla2.inscribir(estudiante1);
            System.out.println("Inscripcion exitosa");

            FileOutputStream fos = new FileOutputStream("evento3.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(evento3);
            oos.close();
            System.out.println("El evento se ha persistido correctamente");
            evento3.recuperarEvento("3");

        } catch (CupoExcedidoException e){
            System.out.println("Error al inscribir: "+ e.getMessage());
        }
        catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e){
            System.out.println("Ha ocurrido un error de E/S");
        } finally {
            System.out.println("Proceso de operacion realizado de forma exitosa");
        }

        //f
        //Caso exitoso
        try {
            EventoUniversitario evento2 = new EventoUniversitario("3", "Baile", 5000, false);
            Charla charla2 = new Charla(2, "Bachata", 5, "Daniela");
            Inscripcion ins = charla2.inscribir(estudiante2);
        } catch (CupoExcedidoException e){
            System.out.println("Error al inscribir: "+ e.getMessage());
        } finally {
            System.out.println("La inscripcion se realizo de forma exitosa");
        }

        //Caso fallido controlado por excepciones
        try {
            EventoUniversitario evento = new EventoUniversitario("4", "Clases", 5000, false);
            Charla charla2 = new Charla(1, "Psicologia", 2, "Francisco");
            Inscripcion ins1 = charla2.inscribir(estudiante1);
            Inscripcion ins2 = charla2.inscribir(estudiante2);
            Inscripcion ins3 = charla2.inscribir(estudiante3);
        } catch (CupoExcedidoException e){
            System.out.println("Error al inscribir: "+ e.getMessage());
        } finally {
            System.out.println("La inscripcion se realizo de forma exitosa");
        }



    }

}