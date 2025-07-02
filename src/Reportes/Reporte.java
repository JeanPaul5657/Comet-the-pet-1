package Reportes;

import Model.Novedades;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Reporte {


    public ByteArrayInputStream crearPdf(List<Novedades> reportes, String dest) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(stream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        // Título general
        Paragraph titulo = new Paragraph("INFORMES SEMANALES")
                .setFont(fontBold)
                .setFontSize(20)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(20)
                .setPadding(10);
        document.add(titulo);

        int contador = 1;
        for (Novedades novedades : reportes) {
            // Subtítulo para cada reporte
            Paragraph subtitulo = new Paragraph("Reporte #" + contador)
                    .setFont(fontBold)
                    .setFontSize(15)
                    .setMarginTop(10)
                    .setMarginBottom(5);
            document.add(subtitulo);

            // Fecha de cada reporte
            Paragraph fecha = new Paragraph("📅 Fecha del reporte: " + novedades.getFechaReporte())
                    .setFont(font)
                    .setFontSize(12)
                    .setMarginBottom(5);
            document.add(fecha);



            // Contenido del reporte
            Paragraph contenido = new Paragraph(novedades.getReporteSemanal())
                    .setFont(font)
                    .setFontSize(13)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setMarginBottom(20);
            document.add(contenido);

            contador++;
        }

        // Pie de página
        Paragraph pie = new Paragraph("Generado automáticamente por el sistema de reportes")
                .setFont(font)
                .setFontSize(9)
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginTop(30);
        document.add(pie);

        document.close();

        // Guardar a archivo
        ByteArrayInputStream stream2 = new ByteArrayInputStream(stream.toByteArray());
        try (OutputStream output = new FileOutputStream(dest)) {
            byte[] buffer = new byte[4096];
            int bytesLeidos;
            while ((bytesLeidos = stream2.read(buffer)) != -1) {
                output.write(buffer, 0, bytesLeidos);
            }
        }
        return null;
    }
}

