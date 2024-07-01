package app;

import config.Conexion;
import java.sql.*;
import java.util.LinkedList;

public class OperacionesProyectos {

    private Statement stmt;
    private ResultSet rs;

    // Método para agregar un nuevo proyecto
    public void agregarProyecto(Conexion con, Proyectos proyecto) throws Exception {
        Connection cnn = null;
        String query = null;

        try {
            cnn = con.establecerConexion();
            stmt = cnn.createStatement();

            query = "INSERT INTO proyectos (proy_id, proy_codigo, proy_nombre, proy_horas_dedicacion, proy_fecha_inicio, proy_fecha_fin, proy_descripcion) VALUES (" +
                    proyecto.getProyId() + ", '" + proyecto.getProyCodigo() + "', '" + proyecto.getProyNombre() + "', '" + proyecto.getProyHorasDedicacion() + "', '" +
                    proyecto.getProyFechaInicio() + "', '" + proyecto.getProyFechaFin() + "', '" + proyecto.getProyDescripcion() + "')";
            stmt.executeUpdate(query);

            cnn.close();
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al agregar el proyecto: " + e.getMessage());
        }
    }

    // Método para actualizar el nombre de un proyecto
    public void actualizarNombreProyecto(Conexion con, int proyId, String nuevoNombre) throws Exception {
        Connection cnn = null;
        String query = null;

        try {
            cnn = con.establecerConexion();
            stmt = cnn.createStatement();

            query = "UPDATE proyectos SET proy_nombre = '" + nuevoNombre + "' WHERE proy_id = " + proyId;
            stmt.executeUpdate(query);

            cnn.close();
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al actualizar el nombre del proyecto: " + e.getMessage());
        }
    }

    // Método para eliminar un proyecto
    public int eliminarProyecto(Conexion con, int proyId) throws Exception {
        Connection cnn = null;
        int resultado = 0;
        String query = null;

        try {
            cnn = con.establecerConexion();
            stmt = cnn.createStatement();

            query = "DELETE FROM proyectos WHERE proy_id = " + proyId;
            resultado = stmt.executeUpdate(query);

            cnn.close();
            return resultado;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al eliminar el proyecto: " + e.getMessage());
        }
    }

    // Método para obtener un proyecto
    public Proyectos obtenerProyecto(Conexion con, int proyId) throws Exception {
        Connection cnn = null;
        Proyectos proyecto = new Proyectos();
        String query = null;

        try {
            cnn = con.establecerConexion();
            stmt = cnn.createStatement();

            query = "SELECT * FROM proyectos WHERE proy_id = " + proyId;
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                proyecto.setProyId(rs.getInt("proy_id"));
                proyecto.setProyCodigo(rs.getString("proy_codigo"));
                proyecto.setProyNombre(rs.getString("proy_nombre"));
                proyecto.setProyHorasDedicacion(rs.getString("proy_horas_dedicacion"));
                proyecto.setProyFechaInicio(rs.getString("proy_fecha_inicio"));
                proyecto.setProyFechaFin(rs.getString("proy_fecha_fin"));
                proyecto.setProyDescripcion(rs.getString("proy_descripcion"));
            } else {
                throw new Exception("No se encontró el proyecto con el ID: " + proyId);
            }

            cnn.close();
            return proyecto;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al obtener el proyecto: " + e.getMessage());
        }
    }

    // Método para obtener todos los proyectos
    public LinkedList<Proyectos> obtenerProyectos(Conexion con) throws Exception {
        Connection cnn = null;
        LinkedList<Proyectos> proyectosList = new LinkedList<>();
        String query = null;

        try {
            cnn = con.establecerConexion();
            stmt = cnn.createStatement();

            query = "SELECT * FROM proyectos";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Proyectos proyecto = new Proyectos();
                proyecto.setProyId(rs.getInt("proy_id"));
                proyecto.setProyCodigo(rs.getString("proy_codigo"));
                proyecto.setProyNombre(rs.getString("proy_nombre"));
                proyecto.setProyHorasDedicacion(rs.getString("proy_horas_dedicacion"));
                proyecto.setProyFechaInicio(rs.getString("proy_fecha_inicio"));
                proyecto.setProyFechaFin(rs.getString("proy_fecha_fin"));
                proyecto.setProyDescripcion(rs.getString("proy_descripcion"));

                proyectosList.add(proyecto);
            }

            cnn.close();
            return proyectosList;
        } catch (SQLException e) {
            if (cnn != null) {
                cnn.close();
            }
            throw new Exception("Error al obtener los proyectos: " + e.getMessage());
        }
    }
}
