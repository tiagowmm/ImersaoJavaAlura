package br.com.tw;

import br.com.tw.enumeradores.EnderecoAPI;
import br.com.tw.manager.ExtratorDeConteudo;
import br.com.tw.manager.ExtratorDeConteudoIMDB;
import br.com.tw.manager.ExtratorDeConteudoNasa;
import br.com.tw.model.Conteudo;
import br.com.tw.service.ClientHttp;
import br.com.tw.service.GeradoraDeFigurinhas;

import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {


    public static void main(String[] args) throws Exception {

        String json = new ClientHttp().buscarDados(EnderecoAPI.TOP_250_MOVIE_FULL.getEndereco());

        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
        List<Conteudo> conteudos = extrator.extrairConteudo(json);

//        String json = new ClientHttp().buscarDados(EnderecoAPI.NASA_DEMO_API.getEndereco());
//
//        ExtratorDeConteudo extrator = new ExtratorDeConteudoNasa();
//        List<Conteudo> conteudos = extrator.extrairConteudo(json);

        for (Conteudo conteudo : conteudos) {
            String titulo = conteudo.getTitle();
            String urlImagem = conteudo.getUrlImage();
            String nomeArquivo = titulo + ".png";

            System.out.println("Título: \u001b[1m" + titulo + "\u001b[m");
            System.out.println("Poster: \u001b[1m" + urlImagem + "\u001b[m");
            System.out.println("\n");

            InputStream inputStream = new URL(urlImagem).openStream();
            GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

        }

    }


}
