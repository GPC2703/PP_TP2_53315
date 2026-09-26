package Ejercicio4.hilos;

import Ejercicio4.modelo.actividades.Actividad;
import Ejercicio4.modelo.EventoUniversitario;
import Ejercicio4.modelo.Inscripcion;

public class EnvioTicketsThread extends Thread{
    public EventoUniversitario evento;

    public EnvioTicketsThread(EventoUniversitario evento) {
        this.evento = evento;
    }

    @Override
    public void run() {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Envío de tickets para: " + evento.getTitulo());
        for (Actividad act : evento.getActividades()) {
            for (Inscripcion ins : act.getInscripciones()) {
                if (ins.getTicket() != null) {
                    try {
                        Thread.sleep(400); //Le aviso profe, puse esto para que no se superpongan en la consola
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(nombreHilo);
                    ins.getTicket().enviarTicket();
                }
            }
        }
        System.out.println("Envío de tickets para: " + evento.getTitulo());
    }
}
