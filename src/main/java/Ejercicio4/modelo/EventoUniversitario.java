package Ejercicio4.modelo;

import Ejercicio4.modelo.actividades.Actividad;
import Ejercicio4.modelo.actividades.Charla;
import Ejercicio4.modelo.actividades.Taller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario implements Serializable {
    private String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos;
    private List<Sala> salas = new ArrayList<Sala>();
    private List<Actividad> actividades = new ArrayList<Actividad>();
    private Sala sala;

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    static {
        cantidadEventos = 0;
    }

    public EventoUniversitario() {
        cantidadEventos++;
    }

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        if (this.gratuito) {
            System.out.println("El costo del evento sera 0");
            return 0;
        } else {
            double costoActividades = 0;
            for (Actividad act : this.actividades) {
                costoActividades += act.calcularCostoMateriales();
            }
            double estimado = (this.costoBase + costoActividades) * 1.21;
            System.out.println("El costo estimado del evento es de: " + estimado);
            return estimado;
        }
    }

    public void asignarSala(Sala sala) {
        this.salas.add(sala);
    }

    public void crearActividad(String tipo, int id, String titulo, int cupo, String disertante, boolean requiereNetbook) {
        if ("Charla".equalsIgnoreCase(tipo)) {
            Actividad charla = new Charla(id, titulo, cupo, disertante);
            this.actividades.add(charla);
        } else if ("Taller".equalsIgnoreCase(tipo)) {
            Actividad taller = new Taller(id, titulo, cupo, requiereNetbook);
            this.actividades.add(taller);
        } else {
            System.out.println("Tipo de actividad no válido: " + tipo);
        }
    }

    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo){
        List <T> resultados = new ArrayList<>();
        for (Actividad act : this.actividades){
           if (tipo.isInstance(act)){
               resultados.add((T) act);
           }
        }
        return resultados;
    }

    public double calcularCostoMateriales(List<? extends Actividad> actividades){
        double total = 0;
       for (Actividad act: actividades){
           total += act.calcularCostoMateriales();
       }
       return total;
    }




    public void agregarActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }

    public boolean persistirEvento(){
        return false;
    }

    public EventoUniversitario recuperarEvento(String id) {
        try {
            FileInputStream fis = new FileInputStream("evento" + id + ".dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EventoUniversitario eventoLeido = (EventoUniversitario) ois.readObject();
            ois.close();
            return eventoLeido;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar el evento: " + e.getMessage());
            return null;
        }
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    @Override
    public String toString() {
        return "EventoUniversitario{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", costoBase=" + costoBase +
                ", gratuito=" + gratuito +
                '}';
    }

    public void mostrarDatos() {
        System.out.println(this.toString());
        System.out.println("Salas: " + this.salas);
        System.out.println("Actividades:");
        for (Actividad act : this.actividades) {
            act.mostrarIdentificacion();
            act.mostrarInscripciones();

        }

    }
}



