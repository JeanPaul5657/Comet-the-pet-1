package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.User;

public class UserDAO {
    private Connection con;
    private PetDAO petDAO;

    public UserDAO() {
        con = null;
        petDAO = new PetDAO();
    }

    // CREATE
    public void addUser(User user){
        String sql = "INSERT INTO Usuario (nombre) VALUES (?)";
        try{
            con = (Connection)ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNombre());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
            ConexionDB.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    // READ por ID (incluye mascotas)
    public User getUserById(int id){
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        try{
            con = (Connection)ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("nombre"), rs.getInt("id"));
                user.getMascotas().addAll(petDAO.getPetsByUserId(id));
                return user;
            }
            ConexionDB.closeConnection();
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // READ todos los usuarios
    public List<User> getAllUsers(){
        String sql = "SELECT * FROM Usuario";
        List<User> lista = new ArrayList<>();
        try {
            con = (Connection) ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString("nombre"), rs.getInt("id"));
                user.getMascotas().addAll(petDAO.getPetsByUserId(user.getId()));
                lista.add(user);
            }
            ConexionDB.closeConnection();
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public boolean updateUser(User user){
        String sql = "UPDATE Usuario SET nombre = ? WHERE id = ?";
        try {
            con = (Connection)ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setInt(2, user.getId());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // DELETE (cascade elimina mascotas gracias a ON DELETE CASCADE)
    public boolean deleteUser(int id){
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try {
            con = (Connection)ConexionDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // Búsqueda de usuarios por nombre (opcional)
    public List<User> findUsersByName(String nombre){
        String sql = "SELECT * FROM Usuario WHERE nombre LIKE ?";
        List<User> lista = new ArrayList<>();
        try{
            con = (Connection)ConexionDB.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString("nombre"), rs.getInt("id"));
                user.getMascotas().addAll(petDAO.getPetsByUserId(user.getId()));
                lista.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
}

