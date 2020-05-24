package ru.ifmo.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    private static final String URL = "http://localhost:8080/sculptures";

    public static void main(String[] args) {
        Client client = Client.create();
        System.out.println("Query: /sculptures");
        display(findSculptures(client, URL, ""));
        System.out.println();

        System.out.println("Query: /sculptures?author=Леонардо да Винчи");
        display(findSculptures(client, URL, "author=Леонардо да Винчи"));
        System.out.println();

        System.out.println("Query: /sculptures?author=Леонардо да Винчи&year=1495");
        display(findSculptures(client, URL, "author=Леонардо да Винчи&year=1495"));
        System.out.println();

        System.out.println("Query: /sculptures?id=7");
        display(findSculptures(client, URL, "id=7"));
        System.out.println();

        System.out.println("Query: /sculptures/7");
        display(findSculptures(client, URL + "/7", ""));
        System.out.println();
    }

    private static List<Sculpture> findSculptures(Client client, String url, String query) {
        WebResource webResource = client.resource(url);
        if (!query.isEmpty()) {
            Map<String, String> map = getQueryMap(query);

            Set<String> keys = map.keySet();
            for (String key : keys) {
                webResource = webResource.queryParam(key, map.get(key));
            }
        }

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        GenericType<List<Sculpture>> type = new GenericType<List<Sculpture>>() {
        };

        return response.getEntity(type);
    }

    private static Map<String, String> getQueryMap(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    private static void display(List<Sculpture> sculptures) {
        for (Sculpture sculpture : sculptures) {
            System.out.println(sculpture);
        }
    }
}
