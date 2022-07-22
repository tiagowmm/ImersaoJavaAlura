package br.com.tw;


import br.com.tw.model.Catalogo;
import br.com.tw.model.Endereco;
import br.com.tw.model.Filme;
import br.com.tw.service.CEPService;
import br.com.tw.util.JsonParser;
import br.com.tw.util.PropertiesUtil;
import com.diogonunes.jcolor.Attribute;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

/**
 * Hello world!
 *
 */
public class LeituraAPIFilmeIMDB {

    private static final String TOP_250_MOVIE_IMDB_API = "https://imdb-api.com/pt/API/Top250Movies/";
    public static final String TOP_250_MOVIE = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
    private static final String TOP_MOVIE = "https://alura-filmes.herokuapp.com/conteudos";


    public static void main( String[] args ) throws IOException, InterruptedException {

        // 1-  Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração
        // (p. ex, um arquivo .properties) ou uma variável de ambiente

        PropertiesUtil propriesdades = new PropertiesUtil();
        String apiKey = propriesdades.obterApiKey();
        System.out.println(apiKey);

        //  2 - Consumir o endpoint de filmes mais populares da API do IMDB.

        String json = enviarRequisicao(TOP_250_MOVIE);
        System.out.println(json);

        // 3 - Mudar o JsonParser para usar uma biblioteca de parsing de JSON como Jackson ou GSON

        ObjectMapper mapper = new ObjectMapper();
        Catalogo catalogo = mapper.readValue(json, Catalogo.class);

        /* 4 -
        Usar sua criatividade para deixar a saída dos dados mais bonitinha: usar emojis com código UTF-8,
        mostrar a nota do filme como estrelinhas, decorar o terminal com cores, negrito e itálico
        usando códigos ANSI, e mais!
         */

        Attribute[] myFormat = new Attribute[]{BRIGHT_YELLOW_TEXT(), MAGENTA_BACK(), BOLD(), ITALIC()};

        for (Filme filme : catalogo.getItems()) {
            System.out.println("Título: \u001b[1m" + filme.getTitle() + "\u001b[m");
            System.out.println("Poster: \u001b[1m" + filme.getImage() + "\u001b[m");
            System.out.println(colorize("Classificação: " + filme.getImDbRating(), myFormat));
            double rating = Double.valueOf(filme.getImDbRating());
            long classificacao = Math.round(rating);
            for( int i = 0; i < classificacao; i++) {
                System.out.print("⭐");
            }
            System.out.println("\n");
        }

        System.out.println("\n");

        /* 5 -
        Desafio supremo: criar alguma maneira para você dar uma avaliação ao filme,
        puxando de algum arquivo de configuração OU pedindo a avaliação para o usuário digitar no terminal.
         */

        System.out.println("Avaliação de Filmes.....");
        System.out.println();

        for (int j = 0; j < catalogo.getItems().size(); j++) {
            System.out.println(j + " = " + catalogo.getItems().get(j).getTitle());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o filme que você deseja avaliar:");
        int filmeEscolhido = scanner.nextInt();

        if (filmeEscolhido < 0 || filmeEscolhido >= 250) {
            System.out.println("Filme inválido!!!");
        } else {

            System.out.println("Informe a nota do Filme entre 1 e 10.");

            int notaFilme = scanner.nextInt();
            if (notaFilme <= 0 || notaFilme >= 10) {
                System.out.println("Nota inválida!!!");
            }

        }

    }

    private static void listarTop250Filmes() throws IOException, InterruptedException {
        String resposta = enviarRequisicao(TOP_MOVIE);
        System.out.println(resposta);

        JsonParser parserJson = new JsonParser();
        List<Map<String, String>> listaFilmes = parserJson.parse(resposta);
        System.out.println(listaFilmes.size());

        for (Map<String, String> filme : listaFilmes) {

            String title = filme.get("title");
            String image = filme.get("image");
            String imDbRating = filme.get("imDbRating");

            System.out.println(title);
            System.out.println(image);
            System.out.println(imDbRating);
            System.out.println();

        }
    }

    private static void buscarEnderecoPorCEP() {
        Endereco endereco = new CEPService().bucarCEP("01.001-000");
        System.out.println(endereco);
    }

    private static String enviarRequisicao(String url) throws IOException, InterruptedException {
        var client  = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        return body;
    }


//    public static void main(String...args) {
//        System.out.println("\u001b[1m Alura");
//        System.out.println("Em negrito \u001b[m Redefinido");
//        System.out.println("\u001b[37m \u001b[44m Alura \u001b[m");
//        System.out.println("\u001b[37;1m \u001b[44;1m Alura \u001b[m");
//        System.out.println("\u001b[97m \u001b[104m Alura \u001b[m");
//        System.out.println("\u001b[38;5;214m \u001b[48;5;153m Alura \u001b[m");
//        System.out.println("\u001b[38;2;255;255;255m \u001b[48;2;42;122;228m Alura \u001b[m");
//        System.out.println("\uD83D\uDC99 💙️");
//        listarTop250Filmes();
//        buscarEnderecoPorCEP();
//    }


}
