package ru.ifmo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.SQLException;
import java.util.List;

@WebService(serviceName = "SculptureService")
public class SculptureWebService {

    @WebMethod(operationName = "getAllSculptures")
    public List<Sculpture> getAllSculptures() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.getAllSculptures();
    }

    @WebMethod(operationName = "findSculptures")
    public List<Sculpture> findSculptures(@WebParam(name = "q") MyRequest request) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.findSculptures(request);
    }

    @WebMethod(operationName = "createSculpture")
    public int createSculpture(@WebParam(name = "name") String name,
                             @WebParam(name = "author") String author,
                             @WebParam(name = "year") int year,
                             @WebParam(name = "material") String material,
                             @WebParam(name = "height") float height,
                             @WebParam(name = "width") float width) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        try {
            return dao.createSculpture(name, author, year, material, height, width);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @WebMethod(operationName = "updateSculpture")
    public int updateSculpture(@WebParam(name = "id") int id,
                                 @WebParam(name = "q") MyRequest request) {
        PostgreSQLDAO dao = new PostgreSQLDAO();

        try {
            return dao.updateSculpture(id, request);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @WebMethod(operationName = "deleteSculpture")
    public int deleteSculpture(@WebParam(name = "id") int id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        try {
            return dao.deleteSculpture(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
