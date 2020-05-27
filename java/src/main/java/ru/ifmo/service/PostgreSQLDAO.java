package ru.ifmo.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    private Connection connection;

    PostgreSQLDAO() {
        this.connection = ConnectionUtil.getConnection();
    }

    public List<Sculpture> getAllSculptures() {
        return executeQuery("SELECT * FROM sculptures");
    }


    public List<Sculpture> findSculptures(String id, String name, String author, String year, String material, String height, String width) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder query = new StringBuilder("");
        boolean where = false;
        if (id != null) {
            sb.append("id = ").append(Integer.parseInt(id)).append(" AND ");
            where = true;
        }

        if (name != null) {
            sb.append("name = '").append(name).append("' AND ");
            where = true;
        }

        if (author != null) {
            sb.append("author = '").append(author).append("' AND ");
            where = true;
        }

        if (year != null) {
            sb.append("year = ").append(Integer.parseInt(year)).append(" AND ");
            where = true;
        }

        if (material != null) {
            sb.append("material = '").append(material).append("' AND ");
            where = true;
        }

        if (height != null) {
            sb.append("height = ").append(Float.parseFloat(height)).append(" AND ");
            where = true;
        }

        if (width != null) {
            sb.append("width = ").append(Float.parseFloat(width)).append(" AND ");
            where = true;
        }

        if (where) {
            if (sb.toString().endsWith(" AND ")) {
                sb.setLength(sb.length() - 5);
            }

            query.append("SELECT * FROM sculptures WHERE ").append(sb.toString());
        } else {
            query.append("SELECT * FROM sculptures");
        }

        return executeQuery(query.toString());
    }

    private List<Sculpture> executeQuery(String sql) {
        List<Sculpture> sculptures = new ArrayList<>();
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
                Sculpture sculpture = new Sculpture(id, name, author, year, material, height, width);
                sculptures.add(sculpture);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sculptures;
    }

    public List<Sculpture> findOne(int id) {
        String query = "SELECT * FROM sculptures WHERE id = " + id;
        List<Sculpture> sculpture = executeQuery(query);
        return sculpture;
    }

    public int createSculpture(Sculpture sculpture) {
        String sql = "INSERT INTO sculptures (name, author, year, material, height, width) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        int id = 0;
        try {
            preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, sculpture.getName());
            preparedStatement.setString(2, sculpture.getAuthor());
            preparedStatement.setInt(3, sculpture.getYear());
            preparedStatement.setString(4, sculpture.getMaterial());
            preparedStatement.setFloat(5, sculpture.getHeight());
            preparedStatement.setFloat(6, sculpture.getWidth());

            int affectedRows = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = (int) generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public int updateSculpture(int id, Sculpture sculpture) {
        String sql = "UPDATE sculptures SET" + createUpdateQuery(sculpture) + " WHERE id=?";
        PreparedStatement preparedStatement = null;
        int affectedRows = 0;
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public int deleteSculpture(int id) {
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

        return affectedRows;
    }


    private String createUpdateQuery(Sculpture sculpture) {
        StringBuilder stringBuilderField = new StringBuilder("(");
        StringBuilder stringBuilderValues = new StringBuilder("(");
        if (sculpture.getId() > 0) {
            stringBuilderField.append("id,");
            stringBuilderValues.append(sculpture.getId()).append(",");
        }

        if (sculpture.getName() != null) {
            stringBuilderField.append("name,");
            stringBuilderValues.append("'").append(sculpture.getName()).append("',");
        }

        if (sculpture.getAuthor() != null) {
            stringBuilderField.append("author,");
            stringBuilderValues.append("'").append(sculpture.getAuthor()).append("',");
        }

        if (sculpture.getYear() > 0) {
            stringBuilderField.append("year,");
            stringBuilderValues.append(sculpture.getYear()).append(",");
        }

        if (sculpture.getMaterial() != null) {
            stringBuilderField.append("material,");
            stringBuilderValues.append("'").append(sculpture.getMaterial()).append("',");
        }

        if (sculpture.getHeight() > 0) {
            stringBuilderField.append("height,");
            stringBuilderValues.append(sculpture.getHeight()).append(",");
        }

        if (sculpture.getWidth() > 0) {
            stringBuilderField.append("width,");
            stringBuilderValues.append(sculpture.getWidth()).append(",");
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
