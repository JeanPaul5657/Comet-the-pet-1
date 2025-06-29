import java.time.LocalDate;

public class Calendario {
    private String descripcion;
    private LocalDate fecha;
    private int usuarioId; // para relacionarlo con el usuario o la mascota si lo deseas


    public Calendario(String descripcion, LocalDate fecha, int usuarioId) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String toString() {
        return " Evento: " + descripcion + " | Fecha: " + fecha + " | Usuario ID: " + usuarioId;
    }
}
