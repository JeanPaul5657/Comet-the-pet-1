public class Pet {
    private String nombre;
    private int edad;
    private String raza;
    private double peso;
    private String sexo;

    // Constructor
    public Pet(String nombre, int edad, String raza, double peso, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.peso = peso;
        this.sexo = sexo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }

    public double getPeso() {
        return peso;
    }

    public String getSexo() {
        return sexo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // Método para mostrar información de la mascota
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Raza: " + raza);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Sexo: " + sexo);
    }
}
