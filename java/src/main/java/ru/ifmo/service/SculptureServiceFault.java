package ru.ifmo.service;

public class SculptureServiceFault {
    private static final String DEFAULT_MESSAGE = "Parameter q cannot be null or empty";
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ru.ifmo.service.SculptureServiceFault defaultInstance() {
        ru.ifmo.service.SculptureServiceFault fault = new ru.ifmo.service.SculptureServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}