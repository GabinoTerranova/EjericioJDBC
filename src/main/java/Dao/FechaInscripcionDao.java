package Dao;

import Modelo.FechaInscripcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FechaInscripcionDao {
    private Connection connection;

    public FechaInscripcionDao() throws SQLException {
        connection = DbConnection.getConnection();
    }

    public void insert(FechaInscripcion fechaInscripcion) {
        String query = "INSERT INTO fechaInscripcion (id_estudiante, id_materia, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, fechaInscripcion.getIdEstudiante());
            preparedStatement.setInt(2, fechaInscripcion.getIdMateria());
            preparedStatement.setDate(3, new java.sql.Date(fechaInscripcion.getFecha().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al insertar inscripción", e);
        }
    }

    public void update(FechaInscripcion fechaInscripcion) {
        String query = "UPDATE fechaInscripcion SET id_estudiante=?, id_materia=?, fecha=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, fechaInscripcion.getIdEstudiante());
            preparedStatement.setInt(2, fechaInscripcion.getIdMateria());
            preparedStatement.setDate(3, new java.sql.Date(fechaInscripcion.getFecha().getTime()));
            preparedStatement.setInt(4, fechaInscripcion.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar inscripción", e);
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM fechaInscripcion WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar inscripción", e);
        }
    }

    public List<FechaInscripcion> selectAll() {
        List<FechaInscripcion> inscripciones = new ArrayList<>();
        String query = "SELECT * FROM fechaInscripcion";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                FechaInscripcion fechaInscripcion = new FechaInscripcion(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_estudiante"),
                        resultSet.getInt("id_materia"),
                        resultSet.getDate("fecha")
                );
                inscripciones.add(fechaInscripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al seleccionar inscripciones", e);
        }
        return inscripciones;
    }
}
