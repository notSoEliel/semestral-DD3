package app;

import config.Conexion;
import java.sql.*;
import java.util.LinkedList;

public class OperacionesInvestigador {

    private Statement stmt;// objeto que permite la manipulaciòn de sentencias SQL
    private ResultSet rs; // objeto que tiene varios métodos que permiten obtener resultados de la tabla de la BD

    // Método para agregar un nuevo investigador
    public void agregarInvestigador(Conexion con,Investigador investigador) throws Exception {
        Connection cnn = null;
        String query = null;

        try {
            cnn = con.establecerConexion(); //estableciendo la conección a la BD
            stmt = cnn.createStatement(); //creando al objeto statement

            query = "INSERT INTO investigadores (inve_id, inve_nombre, inve_area, inve_codigo) VALUES (" + 
            investigador.getInveId() + ", '" + investigador.getInveNombre() + "', '" + investigador.getInveArea() + "', '" + investigador.getInveCodigo() + "')";
            stmt.executeUpdate(query); //ejecutando el query   
            
            cnn.close();
        } catch (SQLException e) {
            cnn.close();
            throw new Exception ("Error... al agregar el registro" + e.getMessage());
        }
    }

    // Método para actualizar el nombre de un investigador
    public void actualizarNombreInvestigador(Conexion con, int inveId, String nuevoNombre) throws Exception {
        Connection cnn = null;
        String query = null;

        try {
            cnn = con.establecerConexion(); //estableciendo la conección a la BD
            stmt = cnn.createStatement(); //creando al objeto statement
            
            query = "UPDATE investigadores SET inve_nombre = '" + nuevoNombre + "' WHERE inve_id = " + inveId;
            stmt.executeUpdate(query); //ejecutando el query  
            
            cnn.close();
        } catch (SQLException e) {
            cnn.close();
            throw new Exception ("Error... al actualizar el campo" + e.getMessage());
        }
    }
    // Método para actualizar el area de un investigador
    public void actualizarAreaInvestigacion(Conexion con, int inveId, String nuevoArea) throws Exception {
        Connection cnn = null;
        String query = null;

        try {
            cnn = con.establecerConexion(); //estableciendo la conección a la BD
            stmt = cnn.createStatement(); //creando al objeto statement
            
            query = "UPDATE investigadores SET inve_area = '" + nuevoArea + "' WHERE inve_id = " + inveId;
            stmt.executeUpdate(query); //ejecutando el query
            
            cnn.close();
        } catch (SQLException e) {
            cnn.close();
            throw new Exception ("Error... al actualizar el campo" + e.getMessage());
        }
    }

    // Método para eliminar un investigador
    public int eliminarInvestigador(Conexion con, int inveId) throws Exception {
        Connection cnn = null; 
        int resultado = 0;
        String query = null;

        try {
            cnn = con.establecerConexion(); //estableciendo la conección a la BD
            stmt = cnn.createStatement(); //creando al objeto statement

            query = "DELETE FROM investigadores WHERE inve_id = " + inveId;
            resultado = stmt.executeUpdate(query); //ejecutando el update del query y guardando el resultado en la variable resultado
            
            cnn.close();
            return  resultado;
        } catch (SQLException e) {
            if(cnn != null){
                cnn.close();
            }
            throw new Exception("ERROR EN EL METODO ELIMINAR " + e.getMessage());
        }
        
    }

    // Método para obtener un investigador
    public Investigador obtenerInvestigador(Conexion con, int inveId) throws Exception {
        Connection cnn = null; 
        Investigador investigador = new Investigador();
        String query = null;
        
        try {
            cnn = con.establecerConexion(); //estableciendo la conección a la BD
            stmt = cnn.createStatement(); //creando al objeto statement

            query = "SELECT * FROM investigadores WHERE inve_id = " + inveId;
            rs = stmt.executeQuery(query); //ejecutando el query y guardando el resultado en la variable rs

            if (rs.next()) {
                investigador.setInveId (rs.getInt("inve_id"));
                investigador.setInveNombre(rs.getString("inve_nombre"));
                investigador.setInveArea(rs.getString("inve_area"));
                investigador.setInveCodigo(rs.getString("inve_codigo"));
                LinkedList<Publicaciones> publicaciones = new LinkedList<>();
                investigador.setPublicaciones(publicaciones);
            } else {
                throw new Exception("No se encontró el investigador con el ID: " + inveId);
            }

            cnn.close();
            return investigador;
            
        } catch (SQLException e) {
            throw new Exception(e.getMessage() + "\nError en la consulta de cedula");
        }
            
        
    }

    // Método para obtener todos los investigadores
    public LinkedList<Investigador> obtenerInvestigadores(Conexion con) throws Exception {
        Connection cnn = null; 
        LinkedList<Investigador> investigadoresList = new LinkedList<>();
        String query = null;
        Investigador investigador = new Investigador();

        try {
            cnn =  con.establecerConexion(); //estableciendo la conección a la BD
            stmt = cnn.createStatement(); //creando al objeto statement
            query = "SELECT * FROM investigadores";
            rs = stmt.executeQuery(query); //ejecutando el query y guardando el resultado en la variable rs

            while (rs.next()) { //recorriendo el resultado de la consulta hasta que no haya mas registros
                // creando un nuevo objeto investigador añadiendo los datos de la consulta
                investigador.setInveId (rs.getInt("inve_id"));
                investigador.setInveNombre(rs.getString("inve_nombre"));
                investigador.setInveArea(rs.getString("inve_area"));
                investigador.setInveCodigo(rs.getString("inve_codigo"));
                LinkedList<Publicaciones> publicaciones = new LinkedList<>();
                investigador.setPublicaciones(publicaciones);

                investigadoresList.add(investigador); // agregando el investigador a la lista
            }

            cnn.close();
            return investigadoresList;
        } catch (Exception e) {
            cnn.close();
            throw new Exception ("Error...en la consulta de todos los registros");
        }
    }
}
