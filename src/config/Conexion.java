package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String usuario = "root";
    private String password = "vivapythonnophp";
    private Connection cnn;

    // Método de conexión
    public Connection establecerConexion() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=investigacion;encrypt=false;trustServerCertificate=false", usuario, password);
            return cnn;
        } catch (ClassNotFoundException e) {
            throw new Exception("Para el programador: " + e + "\n\nPara el usuario: Error... No se pudo cargar el driver de SQL Server");
        } catch (SQLException e) {
            throw new Exception("Para el programador: " + e + "\n\nPara el usuario: Error... No se pudo establecer la conexión");
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() throws SQLException {
        if (cnn != null && !cnn.isClosed()) {
            cnn.close();
        }
    }
}
