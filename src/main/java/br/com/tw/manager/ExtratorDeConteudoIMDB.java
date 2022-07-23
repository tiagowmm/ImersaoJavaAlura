package br.com.tw.manager;

import br.com.tw.model.Conteudo;
import br.com.tw.service.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {


    @Override
    public List<Conteudo> extrairConteudo(String json) {

        List<Conteudo> listaConteudo = new ArrayList<>();

        JsonParser parser = new JsonParser();
        List<Map<String, String>> atributos = parser.parse(json);

        for (Map<String, String> atributo : atributos) {
            String titulo = atributo.get("title");
            String urlImage = atributo.get("image");

            String imagem = "";
            if (urlImage.indexOf("@") >= 0) {

//                imagem = urlImage.replaceAll("(@+)(.*).jpg$", "$1.jpg");

                imagem = urlImage.replaceAll(urlImage.substring(
                        urlImage.lastIndexOf("@") + 1,
                        urlImage.length()), ".jpg");
            } else {
                imagem = urlImage;
            }

            Conteudo conteudo = new Conteudo(titulo, imagem);
            listaConteudo.add(conteudo);
        }

        return listaConteudo;
    }

}
