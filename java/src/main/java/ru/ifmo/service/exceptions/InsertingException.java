package ru.ifmo.service.exceptions;

import ru.ifmo.service.SculptureServiceFault;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "ru.ifmo.service.SculptureServiceFault")
public class InsertingException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final SculptureServiceFault fault;

    public InsertingException(String message, SculptureServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public InsertingException(String message, SculptureServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public SculptureServiceFault getFaultInfo() {
        return fault;
    }
}
