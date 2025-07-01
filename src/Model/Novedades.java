package Model;

import java.time.LocalDate;

public class Novedades {
    private String reporteSemanal;
    private LocalDate fechaReporte;


    public Novedades(String reporteSemanal, LocalDate fechaReporte) {
        this.reporteSemanal = reporteSemanal;
        this.fechaReporte = fechaReporte;
    }


    public String getReporteSemanal() {
        return reporteSemanal;
    }

    public void setReporteSemanal(String reporteSemanal) {
        this.reporteSemanal = reporteSemanal;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    // Método para generar un informe
    public String generarInforme() {
        return "Informe Semanal (" + fechaReporte + ")\n" +
                "---------------------------------------\n" +
                reporteSemanal + "\n";
    }


    public String toString() {
        return "Fecha del reporte: " + fechaReporte + "\n" +
                "Resumen: " + reporteSemanal;
    }
}