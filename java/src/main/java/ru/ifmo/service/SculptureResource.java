package ru.ifmo.service;


import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/sculptures")
@Produces({MediaType.APPLICATION_JSON})
public class SculptureResource {
    @GET
    public List<Sculpture> find(@Context UriInfo info) {
        String id = info.getQueryParameters().getFirst("id");
        String name = info.getQueryParameters().getFirst("name");
        String author = info.getQueryParameters().getFirst("author");
        String year = info.getQueryParameters().getFirst("year");
        String material = info.getQueryParameters().getFirst("material");
        String height = info.getQueryParameters().getFirst("height");
        String width = info.getQueryParameters().getFirst("width");
        return new PostgreSQLDAO().findSculptures(id, name, author, year, material, height, width);
    }

    @GET
    @Path("/{id}")
    public List<Sculpture> getOne(@PathParam("id") int id) {
        return new PostgreSQLDAO().findOne(id);
    }

  
    @POST
    @Consumes("application/json")
    public String create(Sculpture sculpture) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return "{\"result\":" + dao.createSculpture(sculpture) + "}";
    }

    @PUT
    @Consumes("application/json")
    @Path("/{id}")
    public String update(@PathParam("id") int id, Sculpture sculpture) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return "{\"result\":" + dao.updateSculpture(id, sculpture) + "}";
    }

    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") int id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return "{\"result\":" + dao.deleteSculpture(id) + "}";
    }
}

