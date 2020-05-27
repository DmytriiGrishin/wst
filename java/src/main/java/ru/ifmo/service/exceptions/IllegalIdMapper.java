package ru.ifmo.service.exceptions;

import ru.ifmo.service.TemplateResponse;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;

@Provider
public class IllegalIdMapper implements ExceptionMapper<IllegalIdException> {

    @Override
    public Response toResponse(IllegalIdException e) {
        return Response.status(ClientResponse.Status.BAD_REQUEST).entity(new TemplateResponse(e.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }
}
