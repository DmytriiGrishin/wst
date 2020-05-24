package ru.ifmo.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClient {

    public static void getStatus(ru.ifmo.client.SculptureWebService sculptureWebService) {
        System.out.println("Sculptures Status");
        List<ru.ifmo.client.Sculpture> sculptures = sculptureWebService.getAllSculptures();
        for (ru.ifmo.client.Sculpture sculpture : sculptures) {
            System.out.println(sculpture.toString());
        }

        System.out.println("Total sculptures: " + sculptures.size());
        System.out.println();
    }

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/SculptureService?wsdl");
        ru.ifmo.client.SculptureService sculptureService = new ru.ifmo.client.SculptureService(url);
        ru.ifmo.client.SculptureWebService sculptureWebService = sculptureService.getSculptureWebServicePort();

        System.out.println("Simple hard code client for service");
        getStatus(sculptureWebService);

        System.out.println("Query: createSculpture?name=Богатыри&author=Виктор Михайлович Васнецов&" +
                "year=1881&material=Маслянные краски&height=295.3&width=446");
        int creatingSculptureId = sculptureWebService.createSculpture(
                "Богатыри",
                "Виктор Михайлович Васнецов",
                1881,
                "Маслянные краски",
                295.3f,
                446);

        System.out.println("Inserting id: " + creatingSculptureId);
        System.out.println();

        getStatus(sculptureWebService);

        System.out.println("Query: createSculpture?name=sculpture&author=author&" +
                "year=2018&material=Акварель&height=30&width=40");
        creatingSculptureId = sculptureWebService.createSculpture(
                "sculpture",
                "author",
                2018,
                "Акварель",
                30,
                40);

        System.out.println("Inserting id: " + creatingSculptureId);
        System.out.println();

        getStatus(sculptureWebService);

        System.out.println("Query: updateSculpture?id=11&name=My own sculpture&author=ITMO&year=2018");
        ru.ifmo.client.MyRequest myRequest = new ru.ifmo.client.MyRequest();
        myRequest.setName("My own sculpture");
        myRequest.setAuthor("ITMO");
        myRequest.setYear(2018);
        creatingSculptureId = sculptureWebService.updateSculpture(11, myRequest);

        System.out.println("Updating status: " + creatingSculptureId);
        System.out.println();

        getStatus(sculptureWebService);

        System.out.println("Query: updateSculpture?id=22&name=My own sculpture&author=ITMO&year=2018");
        creatingSculptureId = sculptureWebService.updateSculpture(22, myRequest);

        System.out.println("Updating status: " + creatingSculptureId);
        System.out.println();

        getStatus(sculptureWebService);

        System.out.println("Query: deleteSculpture?id=11");
        creatingSculptureId = sculptureWebService.deleteSculpture(11);

        System.out.println("Delete status: " + creatingSculptureId);
        System.out.println();

        getStatus(sculptureWebService);
    }
}