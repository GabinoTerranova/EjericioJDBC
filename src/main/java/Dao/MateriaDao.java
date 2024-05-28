package Dao;

import Modelo.Materia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {
    private Connection connection;

    public MateriaDao() throws SQLException {
        connection = DbConnection.getConnection();
    }

    public void insert(Materia materia) throws SQLException {
        String query = "INSERT INTO materias (nombre) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, materia.getNombre());
            preparedStatement.executeUpdate();
        }
    }

    public void update(Materia materia) throws SQLException {
        String query = "UPDATE materias SET nombre=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, materia.getNombre());
            preparedStatement.setInt(2, materia.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM materias WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Materia> selectAll() throws SQLException {
        List<Materia> materias = new ArrayList<>();
        String query = "SELECT * FROM materias";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Materia materia = new Materia(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre")
                );
                materias.add(materia);
            }
        }
        return materias;
    }
}
