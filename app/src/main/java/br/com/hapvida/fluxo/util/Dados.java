package br.com.hapvida.fluxo.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.com.hapvida.fluxo.entity.Funcionalidade;
import br.com.hapvida.fluxo.entity.Pessoa;

public class Dados {

    private Context context;

    public Dados(Context context) {
        this.context = context;
    }

    public List<Pessoa> getPessoas(){
        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Patrícia Holanda", "patricia@gmail.com"));
        pessoas.add(new Pessoa("Dannuta Albuquerque", "dannuta@gmail.com"));
        pessoas.add(new Pessoa("Reges Pontes", "reges@gmail.com"));
        pessoas.add(new Pessoa("Alexandre Magalhães", "alexandre@gmail.com"));
        pessoas.add(new Pessoa("Tiago Pinho", "tiago@gmail.com"));

        return pessoas;
    }

    public List<Funcionalidade> getFuncionalidades(){
        List<Funcionalidade> funcionalidades = new ArrayList<>();

        funcionalidades.add(new Funcionalidade("01", "Funcionalidade 01\n29/09/2018"));
        funcionalidades.add(new Funcionalidade("02", "Funcionalidade 02\n29/09/2018"));
        funcionalidades.add(new Funcionalidade("03", "Funcionalidade 03\n29/09/2018"));

        return funcionalidades;
    }
}
