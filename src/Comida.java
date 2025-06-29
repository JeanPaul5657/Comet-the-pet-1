public class Comida {
    private String tipoMascota;
    private String nombreProducto;
    private double cantidadKg;
    private String marca;

    // Constructor
    public Comida(String tipoMascota, String nombreProducto, double cantidadKg, String marca) {
        this.tipoMascota = tipoMascota;
        this.nombreProducto = nombreProducto;
        this.cantidadKg = cantidadKg;
        this.marca = marca;
    }

    // Getters y Setters
    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(double cantidadKg) {
        this.cantidadKg = cantidadKg;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Comida para " + tipoMascota +
                "\nProducto: " + nombreProducto +
                "\n Cantidad: " + cantidadKg + " kg" +
                "\n Marca: " + marca;
    }
}
