package br.com.tw.manager;

import br.com.tw.model.Conteudo;
import br.com.tw.service.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {

    @Override
    public List<Conteudo> extrairConteudo(String json) {

        List<Conteudo> listaConteudo = new ArrayList<>();

        JsonParser parser = new JsonParser();
        List<Map<String, String>> atributos = parser.parse(json);

        for (Map<String, String> atributo : atributos) {
            String titulo = atributo.get("title");
            String urlImage = atributo.get("url");
            Conteudo conteudo = new Conteudo(titulo, urlImage);
            listaConteudo.add(conteudo);
        }

        return listaConteudo;
    }
}
