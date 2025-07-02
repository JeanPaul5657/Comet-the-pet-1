package Model;

import Database.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class User {

    // Atributos
    private String nombre;
    private int id;
    private List<Pet> mascotas;

    // Constructor
    public User(String nombre) {
        this.nombre = nombre;
        mascotas = new ArrayList<Pet>();
    }
    public User(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        mascotas = new ArrayList<Pet>();
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

    public List<Pet> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Pet> mascotas) {
        this.mascotas = mascotas;
    }

    // Método para mostrar información del usuario
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
    }
}

