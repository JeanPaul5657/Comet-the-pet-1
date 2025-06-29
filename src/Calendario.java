import java.time.LocalDate;

public class Calendario {
    private LocalDate fechaBaño;
    private LocalDate fechaCompraAlimentos;
    private LocalDate fechaCumpleaños;

    // Constructor
    public Calendario(LocalDate fechaBaño, LocalDate fechaCompraAlimentos, LocalDate fechaCumpleaños) {
        this.fechaBaño = fechaBaño;
        this.fechaCompraAlimentos = fechaCompraAlimentos;
        this.fechaCumpleaños = fechaCumpleaños;
    }

    // Getters y Setters
    public LocalDate getFechaBaño() {
        return fechaBaño;
    }

    public void setFechaBaño(LocalDate fechaBaño) {
        this.fechaBaño = fechaBaño;
    }

    public LocalDate getFechaCompraAlimentos() {
        return fechaCompraAlimentos;
    }

    public void setFechaCompraAlimentos(LocalDate fechaCompraAlimentos) {
        this.fechaCompraAlimentos = fechaCompraAlimentos;
    }

    public LocalDate getFechaCumpleaños() {
        return fechaCumpleaños;
    }

    public void setFechaCumpleaños(LocalDate fechaCumpleaños) {
        this.fechaCumpleaños = fechaCumpleaños;
    }

    public String toString() {
        return " Calendario de eventos:\n" +
                "Fecha de baño: " + fechaBaño + "\n" +
                "Fecha de compra de alimentos: " + fechaCompraAlimentos + "\n" +
                "Cumpleaños: " + fechaCumpleaños;
    }
}
