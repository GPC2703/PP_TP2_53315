package Ejercicio4.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;

    public Inscripcion(Estudiante estudiante, String estado) {
        this.fecha = LocalDate.now();
        this.estado = estado;
        this.estudiante = estudiante;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setTicket(TicketDeAcceso ticket) {
        this.ticket = ticket;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public TicketDeAcceso getTicket() {
        return ticket;
    }

    private TicketDeAcceso ticket;

    @Override
    public String toString() {
        return "Inscripcion{" +
                "fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", estudiante=" + estudiante +
                '}';
    }

    public class TicketDeAcceso {
        private String idTicket;
        private LocalDate fechaEmision;

        public TicketDeAcceso(String idTicket) {
            this.idTicket = idTicket;
            this.fechaEmision = LocalDate.now();
        }

        public void enviarTicket(){
            System.out.println("Enviando "+ idTicket + " (este ticket fue emitido: "+ fechaEmision +")");
        }
    }


}
