package ru.ifmo.service;

import ru.ifmo.service.exceptions.InsertingException;
import ru.ifmo.service.exceptions.InvalidEntityException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    private Connection connection;

    PostgreSQLDAO() {
        this.connection = ru.ifmo.service.ConnectionUtil.getConnection();
    }

    public List<ru.ifmo.service.Sculpture> getAllSculptures() {
        return executeQuery("SELECT * FROM sculptures");
    }

    public List<ru.ifmo.service.Sculpture> findSculptures(MyRequest request) {
        String sql = "SELECT * FROM sculptures WHERE " +
                "(id = " + request.getId() + " OR " + request.getId() + " = 0) AND " +
                "(name = '" + request.getName() + "' OR '" + request.getName() + "' = '' OR '" + request.getName() + "' = '?') AND " +
                "(author = '" + request.getAuthor() + "' OR '" + request.getAuthor() + "' = '' OR '" + request.getAuthor() + "' = '?') AND " +
                "(year = " + request.getYear() + " OR " + request.getYear() + " = 0) AND " +
                "(material = '" + request.getMaterial() + "' OR '" + request.getMaterial() + "' = '' OR '" + request.getMaterial() + "' = '?') AND " +
                "(height = " + request.getHeight() + " OR " + request.getHeight() + " = 0) AND " +
                "(width = " + request.getWidth() + " OR " + request.getWidth() + " = 0)";

        return executeQuery(sql);
    }

    public int createSculpture(String name, String author, int year, String material, float height, float width) throws InsertingException {
        String sql = "INSERT INTO sculptures (name, author, year, material, height, width) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        int id = 0;
        try {
            preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, year);
            preparedStatement.setString(4, material);
            preparedStatement.setFloat(5, height);
            preparedStatement.setFloat(6, width);

            int affectedRows = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = (int) generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (id == 0) {
            ru.ifmo.service.SculptureServiceFault fault = ru.ifmo.service.SculptureServiceFault.defaultInstance();
            fault.setMessage("Error During creation entity");
            throw new InsertingException("Error During creation entity", fault);
        }

        return id;
    }

    public int updateSculpture(int id, MyRequest request) throws InvalidEntityException {
        String sql = "UPDATE sculptures SET" + createUpdateQuery(request) + " WHERE id=?";

        PreparedStatement preparedStatement = null;
        int affectedRows = 0;
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (affectedRows == 0) {
            ru.ifmo.service.SculptureServiceFault fault = ru.ifmo.service.SculptureServiceFault.defaultInstance();
            fault.setMessage("Invalid entity");
            throw new InvalidEntityException("Invalid entity", fault);
        }

        return affectedRows;
    }

    public int deleteSculpture(int id) throws InvalidEntityException {
        String sql = "DELETE FROM sculptures WHERE id = ?";

        PreparedStatement preparedStatement = null;
        int affectedRows = 0;
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (affectedRows == 0) {
            ru.ifmo.service.SculptureServiceFault fault = ru.ifmo.service.SculptureServiceFault.defaultInstance();
            fault.setMessage("Invalid entity");
            throw new InvalidEntityException("Invalid entity", fault);
        }

        return affectedRows;
    }

    private List<ru.ifmo.service.Sculpture> executeQuery(String sql) {
        List<ru.ifmo.service.Sculpture> sculptures = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                String material = rs.getString("material");
                float height = rs.getFloat("height");
                float width = rs.getFloat("width");
                ru.ifmo.service.Sculpture sculpture = new ru.ifmo.service.Sculpture(id, name, author, year, material, height, width);
                sculptures.add(sculpture);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ru.ifmo.service.PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sculptures;
    }

    private String createUpdateQuery(MyRequest request) {
        StringBuilder stringBuilderField = new StringBuilder("(");
        StringBuilder stringBuilderValues = new StringBuilder("(");
        if (request.getId() > 0) {
            stringBuilderField.append("id,");
            stringBuilderValues.append(request.getId()).append(",");
        }

        if (!request.getName().equals("?") && !request.getName().equals("")) {
            stringBuilderField.append("name,");
            stringBuilderValues.append("'").append(request.getName()).append("',");
        }

        if (!request.getAuthor().equals("?") && !request.getAuthor().equals("")) {
            stringBuilderField.append("author,");
            stringBuilderValues.append("'").append(request.getAuthor()).append("',");
        }

        if (request.getYear() > 0) {
            stringBuilderField.append("year,");
            stringBuilderValues.append(request.getYear()).append(",");
        }

        if (!request.getMaterial().equals("?") && !request.getMaterial().equals("")) {
            stringBuilderField.append("material,");
            stringBuilderValues.append("'").append(request.getMaterial()).append("',");
        }

        if (request.getHeight() > 0) {
            stringBuilderField.append("height,");
            stringBuilderValues.append(request.getHeight()).append(",");
        }

        if (request.getWidth() > 0) {
            stringBuilderField.append("width,");
            stringBuilderValues.append(request.getWidth()).append(",");
        }

        if (stringBuilderField.toString().endsWith(",")) {
            stringBuilderField.setLength(stringBuilderField.length() - 1);
            stringBuilderValues.setLength(stringBuilderValues.length() - 1);
        }

        stringBuilderField.append(")");
        stringBuilderValues.append(")");

        return stringBuilderField.toString() + " = " + stringBuilderValues.toString();
    }
}
