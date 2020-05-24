package ru.ifmo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
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
}
