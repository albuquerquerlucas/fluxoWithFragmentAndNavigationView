package br.com.hapvida.fluxo.entity;

import java.io.Serializable;

public class Funcionalidade implements Serializable {

    private String id;
    private String nm_funcao;

    public Funcionalidade() {
    }

    public Funcionalidade(String id, String nm_funcao) {
        this.id = id;
        this.nm_funcao = nm_funcao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNm_funcao() {
        return nm_funcao;
    }

    public void setNm_funcao(String nm_funcao) {
        this.nm_funcao = nm_funcao;
    }
}
