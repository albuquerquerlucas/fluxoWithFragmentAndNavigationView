package br.com.hapvida.fluxo.fragment.ctx1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.hapvida.fluxo.R;
import br.com.hapvida.fluxo.adapter.FuncionalidadeAdapter;
import br.com.hapvida.fluxo.util.Dados;

public class Contexto11Frag extends Fragment {

    ListView lvFuncionalidades;
    FuncionalidadeAdapter adapter;
    Dados dados;

    public Contexto11Frag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contexto11, container, false);

        lvFuncionalidades = (ListView) view.findViewById(R.id.lista_funcionalidades);
        showListView(view);

        return view;
    }

    private void showListView(View v){
        dados = new Dados(v.getContext());
        adapter = new FuncionalidadeAdapter(v.getContext(), dados.getFuncionalidades());
        lvFuncionalidades.setAdapter(adapter);
    }
}
