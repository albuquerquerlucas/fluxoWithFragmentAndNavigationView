package br.com.hapvida.fluxo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.hapvida.fluxo.R;
import br.com.hapvida.fluxo.entity.Pessoa;
import br.com.hapvida.fluxo.fragment.ctx1.Contexto11Frag;

public class PessoaAdapter extends BaseAdapter {

    private Context context;
    private List<Pessoa> pessoas;
    private LayoutInflater inflater;

    public PessoaAdapter(Context context, List<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return pessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        final ViewHolder holder = new ViewHolder();
        View rowView = view;
        rowView = inflater.inflate(R.layout.item_pessoas_list, null);

        holder.txtNome = (TextView) rowView.findViewById(R.id.txt_item_nome);
        holder.txtEmail = (TextView) rowView.findViewById(R.id.txt_item_email);
        holder.imgDetalhes = (ImageView) rowView.findViewById(R.id.img_item_detalhes);

        holder.txtNome.setText(pessoas.get(position).getNome());
        holder.txtEmail.setText(pessoas.get(position).getEmail());

        holder.imgDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + holder.txtNome.getText().toString(), Toast.LENGTH_SHORT).show();
                Contexto11Frag fragment = new Contexto11Frag();
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.area_fragmento, fragment).addToBackStack(null).commit();
            }
        });

        return rowView;
    }

    private class ViewHolder{
        TextView txtNome;
        TextView txtEmail;
        ImageView imgDetalhes;
    }
}
