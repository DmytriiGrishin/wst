package ru.ifmo.service;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "SculptureService")
public class SculptureWebService {
    @Resource(lookup = "jdbc/studs")
    private DataSource dataSource;

    @WebMethod(operationName = "getAllSculptures")
    public List<ru.ifmo.service.Sculpture> getAllSculptures() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getAllSculptures();
    }

    @WebMethod(operationName = "findPSculptures")
    public List<ru.ifmo.service.Sculpture> findSculptures(@WebParam(name = "q") MyRequest request) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.findSculptures(request);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ru.ifmo.service.SculptureWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}