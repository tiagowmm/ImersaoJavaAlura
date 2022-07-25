package br.com.tw.enumeradores;

public enum EnderecoAPI {

    IMDB_TOP_250_MOVIE("https://imdb-api.com/pt/API/Top250Movies/"),
    TOP_250_MOVIE_FULL("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"),
    TOP_250_TVS("https://api.mocki.io/v2/549a5d8b/Top250TVs"),
    TOP_250_MOVIE("https://api.mocki.io/v2/549a5d8b/Top250Movies"),
    MOST_POPULAR_TVS("https://api.mocki.io/v2/549a5d8b/MostPopularTVs"),
    NASA_DEMO_API2("https://api.mocki.io/v2/549a5d8b/NASA-APOD"),
    NASA_DEMO_API("https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json"),
    MOST_POPULAR_MOVIE("https://api.mocki.io/v2/549a5d8b/MostPopularMovies");

    private String endereco;

    private EnderecoAPI(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

}
