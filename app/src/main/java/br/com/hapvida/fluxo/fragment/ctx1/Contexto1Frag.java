package br.com.hapvida.fluxo.fragment.ctx1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.hapvida.fluxo.util.Dados;
import br.com.hapvida.fluxo.R;
import br.com.hapvida.fluxo.adapter.PessoaAdapter;

public class Contexto1Frag extends Fragment {

    ListView lvPessoas;
    PessoaAdapter adapter;
    Dados dados;

    public Contexto1Frag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contexto1, container, false);

        lvPessoas = (ListView) view.findViewById(R.id.lista_pessoas);
        showListView(view);

        return view;
    }

    private void showListView(View v){
        dados = new Dados(v.getContext());
        adapter = new PessoaAdapter(v.getContext(), dados.getPessoas());
        lvPessoas.setAdapter(adapter);
    }
}
