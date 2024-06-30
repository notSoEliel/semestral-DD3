package config;
import java.sql.*;
public class Conexion {
    private String  usuario= "root";
    private String password = "vivapythonnophp";

    private Connection cnn;

    // Método de conexion
    public Connection establecerConexion() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=investigacion;encrypt=false;trustServerCertificate=false", usuario, password);
            return cnn;
        }
        catch (SQLException e){
            throw new Exception ("\n" + e +
                    "\n\nPara el usuario: Error... No se pudo establecer la conexion");
        }
    }
}