package br.com.tw.model;

import java.io.Serializable;

public class Endereco implements Serializable {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Endereco{");
        sb.append("cep='").append(cep).append('\'');
        sb.append(", logradouro='").append(logradouro).append('\'');
        sb.append(", complemento='").append(complemento).append('\'');
        sb.append(", bairro='").append(bairro).append('\'');
        sb.append(", localidade='").append(localidade).append('\'');
        sb.append(", uf='").append(uf).append('\'');
        sb.append(", ibge='").append(ibge).append('\'');
        sb.append(", gia='").append(gia).append('\'');
        sb.append(", ddd='").append(ddd).append('\'');
        sb.append(", siafi='").append(siafi).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
