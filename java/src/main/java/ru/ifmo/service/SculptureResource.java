package ru.ifmo.service;


import org.postgresql.util.Base64;
import ru.ifmo.service.exceptions.*;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.HttpHeaders;
import java.util.StringTokenizer;

@Path("/sculptures")
@Produces({MediaType.APPLICATION_JSON})
public class SculptureResource {

    private static final String AUTH_HEADER_KEY = "Authorization";
    private static final String AUTH_HEADER_PREFIX = "Basic ";

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

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
    public List<Sculpture> getOne(@PathParam("id") int id) throws IllegalIdException {
        if (id <= 0) {
            throw IllegalIdException.DEFAULT_INSTANCE;
        }

        return new PostgreSQLDAO().findOne(id);
    }

    @POST
    @Consumes("application/json")
    public String create(@Context HttpHeaders headers, Sculpture sculpture) throws InvalidCreatingParametersException,
            InsertingException, AuthException {

        if (!isAuthenticated(headers)) {
            throw AuthException.DEFAULT_INSTANCE;
        }

        if (sculpture.getName() == null || sculpture.getName().trim().isEmpty()) {
            throw new InvalidCreatingParametersException("Invalid creating parameter: name");
        }

        if (sculpture.getAuthor() == null || sculpture.getAuthor().trim().isEmpty()) {
            throw new InvalidCreatingParametersException("Invalid creating parameter: author");
        }

        if (sculpture.getYear() <= 0) {
            throw new InvalidCreatingParametersException("Invalid creating parameter: year");
        }

        if (sculpture.getMaterial() == null || sculpture.getMaterial().trim().isEmpty()) {
            throw new InvalidCreatingParametersException("Invalid creating parameter: material");
        }

        if (sculpture.getHeight() <= 0) {
            throw new InvalidCreatingParametersException("Invalid creating parameter: height");
        }

        if (sculpture.getWidth() <= 0) {
            throw new InvalidCreatingParametersException("Invalid creating parameter: width");
        }

        PostgreSQLDAO dao = new PostgreSQLDAO();
        return "{\"result\":" + dao.createSculpture(sculpture) + "}";
    }

    @PUT
    @Consumes("application/json")
    @Path("/{id}")
    public String update(@Context HttpHeaders headers, @PathParam("id") int id, Sculpture sculpture) throws IllegalIdException, InvalidEntityException,
            InvalidUpdatingParametersException, AuthException {
        if (!isAuthenticated(headers)) {
            throw AuthException.DEFAULT_INSTANCE;
        }

        if (id <= 0) {
            throw IllegalIdException.DEFAULT_INSTANCE;
        }

        if ((sculpture.getName() == null || sculpture.getName().trim().isEmpty()) &&
                (sculpture.getAuthor() == null || sculpture.getAuthor().trim().isEmpty()) &&
                (sculpture.getYear() <= 0) &&
                (sculpture.getMaterial() == null || sculpture.getMaterial().trim().isEmpty()) &&
                (sculpture.getHeight() <= 0) &&
                (sculpture.getWidth() <= 0)) {
            throw InvalidUpdatingParametersException.DEFAULT_INSTANCE;
        }

        PostgreSQLDAO dao = new PostgreSQLDAO();
        return "{\"result\":" + dao.updateSculpture(id, sculpture) + "}";
    }

    @DELETE
    @Path("/{id}")
    public String delete(@Context HttpHeaders headers, @PathParam("id") int id) throws IllegalIdException,
            InvalidEntityException, AuthException {
        if (!isAuthenticated(headers)) {
            throw AuthException.DEFAULT_INSTANCE;
        }

        if (id <= 0) {
            throw IllegalIdException.DEFAULT_INSTANCE;
        }

        PostgreSQLDAO dao = new PostgreSQLDAO();
        return "{\"result\":" + dao.deleteSculpture(id) + "}";
    }

    private boolean isAuthenticated(HttpHeaders headers) {
        List<String> authHeader = headers.getRequestHeaders().get(AUTH_HEADER_KEY);
        if (authHeader == null) {
            return false;
        }

        String authToken = authHeader.get(0);
        if (authToken.isEmpty()) {
            return false;
        }

        authToken = authToken.replaceFirst(AUTH_HEADER_PREFIX, "");
        String decodedString = new String(Base64.decode(authToken));
        StringTokenizer stringTokenizer = new StringTokenizer(decodedString, ":");
        String username = stringTokenizer.nextToken();
        String password = stringTokenizer.nextToken();

        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}

