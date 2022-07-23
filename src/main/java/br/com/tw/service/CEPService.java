package br.com.tw.service;

import br.com.tw.model.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CEPService {

    private static final String URL = "https://viacep.com.br/ws/";
    public static final String JSON = "/json/";

    public Endereco bucarCEP(String cep) {

        Endereco endereco = null;
        try {

            if (cep != null && !"".equals(cep)) {

                String numero = removerMascara(cep);

                String adress =  URL + numero + JSON;
                String body = new ClientHttp().buscarDados(adress);
                System.out.println(body);

                ObjectMapper mapper = new ObjectMapper();
                endereco = mapper.readValue(body, Endereco.class);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return endereco;
    }

    private String removerMascara(String cep) {
        String numero = cep.replaceAll("\\.", "")
                .replaceAll("-", "")
                .trim();
        return numero;
    }

//    private String send(String adress) throws IOException, InterruptedException {
//        var http = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder(URI.create(adress)).build();
//        String body;
//        body = http.send(request, HttpResponse.BodyHandlers.ofString()).body();
//        return body;
//    }

}
