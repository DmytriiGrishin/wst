package ru.ifmo.client;

import org.postgresql.util.Base64;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebServiceClient {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private static void getStatus(ru.ifmo.client.SculptureWebService sculptureWebService) {
        System.out.println("Sculptures Status");
        List<ru.ifmo.client.Sculpture> sculptures = sculptureWebService.getAllSculptures();
        for (ru.ifmo.client.Sculpture sculpture : sculptures) {
            System.out.println(sculpture.toString());
        }

        System.out.println("Total sculptures: " + sculptures.size());
        System.out.println();
    }

    public static void main(String[] args) throws MalformedURLException {
        String authToken = "Basic " + Base64.encodeBytes((USERNAME + ":" + PASSWORD).getBytes());

        URL url = new URL("http://localhost:8080/SculptureService?wsdl");
        ru.ifmo.client.SculptureService sculptureService = new ru.ifmo.client.SculptureService(url);
        ru.ifmo.client.SculptureWebService sculptureWebService = sculptureService.getSculptureWebServicePort();

        Map<String, List<String>> credentials = new HashMap<>();
        credentials.put("Authorization", Collections.singletonList(authToken));
        BindingProvider bindingProvider = (BindingProvider) sculptureWebService;
        bindingProvider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, credentials);
        System.out.println("Simple hard code client for service");
        getStatus(sculptureWebService);


        System.out.println("Query with auth: createSculpture?name=Богатыри&author=Виктор Михайлович Васнецов");
        int creatingSculptureId = 0;
        try {
            creatingSculptureId = sculptureWebService.createSculpture(
                    "Богатыри",
                    "Виктор Михайлович Васнецов",
                    0,
                    "",
                    0,
                    0);
        } catch (ru.ifmo.client.InsertingException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidCreatingParametersException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + creatingSculptureId);
        System.out.println();


        credentials.remove("Authorization");
        System.out.println("Query without auth: createSculpture?name=Богатыри&author=Виктор Михайлович Васнецов&" +
                "year=1881&material=Маслянные краски&height=295.3&width=446");
        int id = 0;
        try {
            id = sculptureWebService.createSculpture(
                    "Богатыри",
                    "Виктор Михайлович Васнецов",
                    1881,
                    "Маслянные краски",
                    295.3f,
                    446);
        } catch (ru.ifmo.client.InsertingException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidCreatingParametersException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + id);
        System.out.println();
        getStatus(sculptureWebService);


        credentials.put("Authorization", Collections.singletonList(authToken));
        System.out.println("Query with auth: createSculpture?name=Богатыри&author=Виктор Михайлович Васнецов&" +
                "year=1881&material=Маслянные краски&height=295.3&width=446");
        id = 0;
        try {
            id = sculptureWebService.createSculpture(
                    "Богатыри",
                    "Виктор Михайлович Васнецов",
                    1881,
                    "Маслянные краски",
                    295.3f,
                    446);
        } catch (ru.ifmo.client.InsertingException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidCreatingParametersException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + id);
        System.out.println();
        getStatus(sculptureWebService);


        System.out.println("Query with auth: updateSculpture?id=10");
        ru.ifmo.client.MyRequest myRequest = new ru.ifmo.client.MyRequest();
        try {
            creatingSculptureId = sculptureWebService.updateSculpture(id, myRequest);
        } catch (ru.ifmo.client.IllegalIdException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.IllegalQException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidEntityException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + creatingSculptureId);
        System.out.println();


        System.out.println("Query with auth: updateSculpture?id=111&name=My own sculpture&author=ITMO&year=2018");
        myRequest.init();
        myRequest.setName("My own sculpture");
        myRequest.setAuthor("ITMO");
        myRequest.setYear(2018);
        try {
            creatingSculptureId = sculptureWebService.updateSculpture(111, myRequest);
        } catch (ru.ifmo.client.IllegalIdException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.IllegalQException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidEntityException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + creatingSculptureId);
        System.out.println();


        credentials.remove("Authorization");
        System.out.println("Query without auth: updateSculpture?id=10&name=My own sculpture&author=ITMO&year=2018");
        try {
            creatingSculptureId = sculptureWebService.updateSculpture(10, myRequest);
        } catch (ru.ifmo.client.IllegalIdException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.IllegalQException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidEntityException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + creatingSculptureId);
        System.out.println();
        getStatus(sculptureWebService);


        credentials.put("Authorization", Collections.singletonList(authToken));
        System.out.println("Query with auth: updateSculpture?id=10&name=My own sculpture&author=ITMO&year=2018");
        try {
            creatingSculptureId = sculptureWebService.updateSculpture(10, myRequest);
        } catch (ru.ifmo.client.IllegalIdException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.IllegalQException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidEntityException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + creatingSculptureId);
        System.out.println();
        getStatus(sculptureWebService);


        System.out.println("Query with auth: deleteSculpture?id=111");
        try {
            creatingSculptureId = sculptureWebService.deleteSculpture(111);
        } catch (ru.ifmo.client.IllegalIdException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidEntityException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + creatingSculptureId);
        System.out.println();


        credentials.remove("Authorization");
        System.out.println("Query without auth: deleteSculpture?id=" + id);
        try {
            creatingSculptureId = sculptureWebService.deleteSculpture(id);
        } catch (ru.ifmo.client.IllegalIdException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidEntityException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + creatingSculptureId);
        System.out.println();
        getStatus(sculptureWebService);


        credentials.put("Authorization", Collections.singletonList(authToken));
        System.out.println("Query with auth: deleteSculpture?id=" + id);
        try {
            creatingSculptureId = sculptureWebService.deleteSculpture(id);
        } catch (ru.ifmo.client.IllegalIdException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.InvalidEntityException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        } catch (ru.ifmo.client.AuthException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("FaultInfo: " + e.getFaultInfo().getMessage());
        }
        System.out.println("Response: " + creatingSculptureId);
        System.out.println();
        getStatus(sculptureWebService);
    }
}