package ru.ifmo.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TemplateResponse {

    public String internalStatus;

    public String message;

    public TemplateResponse() {
    }

    public TemplateResponse(String message) {
        this.internalStatus = "Error";
        this.message = message;
    }
}
