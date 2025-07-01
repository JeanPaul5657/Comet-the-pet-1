package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Pet;
public class PetDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public PetDAO() {
        con = null;
        st = null;
        rs = null;
    }

    // CREATE
    public void addPet(Pet pet, int usuarioId) {
        String sql = "INSERT INTO Mascota (nombre, edad, raza, peso, sexo, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = (Connection) ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pet.getNombre());
            ps.setInt(2, pet.getEdad());
            ps.setString(3, pet.getRaza());
            ps.setDouble(4, pet.getPeso());
            ps.setString(5, pet.getSexo());
            ps.setInt(6, usuarioId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pet.setId(rs.getInt(1));
            }
            ConexionDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // READ por ID
    public Pet getPetById(int id){
        String sql = "SELECT * FROM Mascota WHERE id = ?";
        try{
            con = (Connection) ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToPet(rs);
                }
            }

            ConexionDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ todas las mascotas de un usuario
    public List<Pet> getPetsByUserId(int usuarioId){
        String sql = "SELECT * FROM Mascota WHERE usuario_id = ?";
        List<Pet> lista = new ArrayList<>();
        try{
             PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapRowToPet(rs));
                }
            }
            ConexionDB.closeConnection();
            return lista;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public boolean updatePet(Pet pet) throws SQLException {
        String sql = "UPDATE Mascota SET nombre=?, edad=?, raza=?, peso=?, sexo=? WHERE id=?";
        try{
            con = (Connection) ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pet.getNombre());
            ps.setInt(2, pet.getEdad());
            ps.setString(3, pet.getRaza());
            ps.setDouble(4, pet.getPeso());
            ps.setString(5, pet.getSexo());
            ps.setInt(6, pet.getId());
            ConexionDB.closeConnection();
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean deletePet(int id){
        String sql = "DELETE FROM Mascota WHERE id = ?";
        try {
            con = (Connection) ConexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ConexionDB.closeConnection();
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mapea una fila de ResultSet a un objeto Pet
    private Pet mapRowToPet(ResultSet rs) throws SQLException {
        Pet pet = new Pet(
                rs.getString("nombre"),
                rs.getInt("edad"),
                rs.getString("raza"),
                rs.getDouble("peso"),
                rs.getString("sexo")
        );
        pet.setId(rs.getInt("id"));
        return pet;
    }
}

