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

    public List<Sculpture> findSculptures(MyRequest request) {
        List<Sculpture> sculptures = new ArrayList<>();
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
}
