package br.com.tw.manager;


import br.com.tw.enumeradores.EnderecoAPI;
import br.com.tw.model.Catalogo;
import br.com.tw.model.Endereco;
import br.com.tw.model.Filme;
import br.com.tw.service.CEPService;
import br.com.tw.service.ClientHttp;
import br.com.tw.service.JsonParser;
import br.com.tw.util.PropertiesUtil;
import com.diogonunes.jcolor.Attribute;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
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

    public static void main(String[] args) throws IOException, InterruptedException {

        // 1-  Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração
        // (p. ex, um arquivo .properties) ou uma variável de ambiente

        PropertiesUtil propriesdades = PropertiesUtil.newPropertiesUtil();
        String apiKey = propriesdades.getAPIKey();
        System.out.println(apiKey);

        //  2 - Consumir o endpoint de filmes mais populares da API do IMDB.

        String json = new ClientHttp().buscarDados(EnderecoAPI.TOP_250_MOVIE_FULL.getEndereco());
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
        String resposta = new ClientHttp().buscarDados(EnderecoAPI.TOP_250_MOVIE.getEndereco());
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
