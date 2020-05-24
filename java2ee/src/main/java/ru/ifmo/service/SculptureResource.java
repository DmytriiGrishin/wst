package ru.ifmo.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



@RequestScoped
@Path("/sculptures")
@Produces({MediaType.APPLICATION_JSON})
public class SculptureResource {

    @Resource(lookup = "jdbc/studs")
    private DataSource dataSource;

    @GET
    public List<Sculpture> find(@Context UriInfo info) {
        String id = info.getQueryParameters().getFirst("id");
        String name = info.getQueryParameters().getFirst("name");
        String author = info.getQueryParameters().getFirst("author");
        String year = info.getQueryParameters().getFirst("year");
        String material = info.getQueryParameters().getFirst("material");
        String height = info.getQueryParameters().getFirst("height");
        String width = info.getQueryParameters().getFirst("width");
        return new PostgreSQLDAO(getConnection()).findSculptures(id, name, author, year, material, height, width);
    }

    @GET
    @Path("/{id}")
    public List<Sculpture> getOne(@PathParam("id") int id) {
        return new PostgreSQLDAO(getConnection()).findOne(id);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SculptureResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}


