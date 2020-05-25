package ru.ifmo.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    private Connection connection;

    PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public List<ru.ifmo.service.Sculpture> getAllSculptures() {
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
}
