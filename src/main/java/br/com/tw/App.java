package br.com.tw;

import br.com.tw.model.Catalogo;
import br.com.tw.model.Filme;
import br.com.tw.util.GeradoraDeFigurinhas;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.diogonunes.jcolor.Ansi.colorize;

public class App {


    public static void main(String[] args) throws Exception {

        String json = enviarRequisicao(LeituraAPIFilmeIMDB.TOP_250_MOVIE);

        ObjectMapper mapper = new ObjectMapper();
        Catalogo catalogo = mapper.readValue(json, Catalogo.class);

        for (Filme filme : catalogo.getItems()) {

            String titulo = filme.getTitle();
            String urlImagem = filme.getImage();
            String nomeArquivo = titulo + ".png";

            InputStream inputStream = new URL(urlImagem).openStream();
            GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println("Título: \u001b[1m" + titulo + "\u001b[m");
            System.out.println("Poster: \u001b[1m" + urlImagem + "\u001b[m");
            System.out.println("Classificação: " + filme.getImDbRating());

            double rating = Double.valueOf(filme.getImDbRating());
            long classificacao = Math.round(rating);

            for( int i = 0; i < classificacao; i++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }

    }


    private static String enviarRequisicao(String url) throws IOException, InterruptedException {
        var client  = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        return body;
    }

}
