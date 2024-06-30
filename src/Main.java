import config.Conexion;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            Conexion obj = new Conexion();
            Connection cnn = obj.establecerConexion();
            System.out.println(":D"); //Para mí para saber que se logró la conexión xd
        } catch (Exception e) {
            e.printStackTrace(); // Para depuración en caso de error
        }
    }
}
