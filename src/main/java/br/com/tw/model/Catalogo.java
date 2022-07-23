package br.com.tw.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Catalogo implements Modelo {

    private String errorMessage;

    private List<Filme> items = new ArrayList<>();


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<Filme> getItems() {
        return items;
    }

    public void setItems(List<Filme> items) {
        this.items = items;
    }
}
