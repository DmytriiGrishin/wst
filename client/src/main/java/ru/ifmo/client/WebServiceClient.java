package ru.ifmo.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/SculptureService?wsdl");
        SculptureService SculptureService = new SculptureService(url);
        SculptureWebService sculptureWebService = SculptureService.getSculptureWebServicePort();

        System.out.println("Simple hard code client for service");

        System.out.println("Query: getAllSculptures");
        List<Sculpture> sculptures = sculptureWebService.getAllSculptures();
        for (Sculpture sculpture : sculptures) {
            System.out.println(sculpture.toString());
        }

        System.out.println("Total sculptures: " + sculptures.size());
        System.out.println();

        System.out.println("Query: findSculptures?name=Леонардо да Винчи");
        MyRequest myRequest = new MyRequest();
        myRequest.setAuthor("Леонардо да Винчи");
        sculptures = sculptureWebService.findSculptures(myRequest);
        for (Sculpture sculpture : sculptures) {
            System.out.println(sculpture.toString());
        }

        System.out.println("Total sculptures: " + sculptures.size());
        System.out.println();

        System.out.println("Query: findSculptures?name=Леонардо да Винчи&year=1495");
        myRequest.setYear(1495);
        sculptures = sculptureWebService.findSculptures(myRequest);
        for (Sculpture sculpture : sculptures) {
            System.out.println(sculpture.toString());
        }

        System.out.println("Total sculptures: " + sculptures.size());
        System.out.println();

        System.out.println("Query: findSculptures?id=7");
        myRequest.setId(7);
        myRequest.setYear(0);
        myRequest.setAuthor("");
        sculptures = sculptureWebService.findSculptures(myRequest);
        for (Sculpture sculpture : sculptures) {
            System.out.println(sculpture.toString());
        }

        System.out.println("Total sculptures: " + sculptures.size());
        System.out.println();
    }
}