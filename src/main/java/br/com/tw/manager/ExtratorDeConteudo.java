package br.com.tw.manager;

import br.com.tw.model.Conteudo;

import java.util.List;

public interface ExtratorDeConteudo {

    List<Conteudo> extrairConteudo(String json);
}
