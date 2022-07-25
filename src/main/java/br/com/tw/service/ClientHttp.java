package br.com.tw.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 *
 */
public class ClientHttp {

    /**
     *
     * @param endereco
     * @return String
     */
    public String buscarDados(String endereco) {
        try {

            var client  = HttpClient.newHttpClient();
            URI uri = URI.create(endereco);
            var request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return body;

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

}
