public class User {
    // Atributos
    private String nombre;
    private int id;

    // Constructor
    public User(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método para mostrar información del usuario
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
    }
}

