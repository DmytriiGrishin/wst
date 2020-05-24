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

    public List<ru.ifmo.service.Sculpture> findSculptures(MyRequest request) {
        List<ru.ifmo.service.Sculpture> sculptures = new ArrayList<>();
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
}
