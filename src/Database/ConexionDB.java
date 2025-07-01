package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection cn = null;
    private static String URLDB = "jdbc:mysql://localhost:3306/baseusuariosmascotas";
    private static String USERDB = "root";
    private static String PASSDB = "";

    public static Connection getConnection() {
        try{
            cn = DriverManager.getConnection(URLDB,USERDB,PASSDB);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cn;
    }

    public static void closeConnection(){
        cn = null;
    }
}
