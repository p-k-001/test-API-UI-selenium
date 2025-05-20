package ui.pages.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtils {

    public static void sendDeleteRequest(String url) throws Exception {
        HttpResponse<String> response;
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(URI.create(url))
                                             .DELETE()
                                             .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        System.out.println("DELETE " + url + " - Status: " + response.statusCode());
    }
}
