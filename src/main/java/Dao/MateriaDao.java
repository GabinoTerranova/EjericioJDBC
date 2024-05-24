package Dao;


import Modelo.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {

    public void insert(Materia materia) throws SQLException {
        String query = "INSERT INTO Materias (nombre, id_estudiante) VALUES (?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, materia.getNombre());
            statement.setInt(2, materia.getIdEstudiante());
            statement.executeUpdate();
        }
    }

    public List<Materia> selectAll() throws SQLException {
        String query = "SELECT * FROM Materias";
        List<Materia> materias = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Materia materia = new Materia();
                materia.setId(resultSet.getInt("id"));
                materia.setNombre(resultSet.getString("nombre"));
                materia.setIdEstudiante(resultSet.getInt("id_estudiante"));
                materias.add(materia);
            }
        }
        return materias;
    }

    public void update(Materia materia) throws SQLException {
        String query = "UPDATE Materias SET nombre = ?, id_estudiante = ? WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, materia.getNombre());
            statement.setInt(2, materia.getIdEstudiante());
            statement.setInt(3, materia.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM Materias WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

