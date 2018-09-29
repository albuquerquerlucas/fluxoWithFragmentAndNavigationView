package br.com.hapvida.fluxo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
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
import br.com.hapvida.fluxo.activity.BiometriaAct;
import br.com.hapvida.fluxo.entity.Funcionalidade;
import br.com.hapvida.fluxo.entity.Pessoa;
import br.com.hapvida.fluxo.fragment.ctx1.Contexto11Frag;

public class FuncionalidadeAdapter extends BaseAdapter {

    private Context context;
    private List<Funcionalidade> funcionalidades;
    private LayoutInflater inflater;

    public FuncionalidadeAdapter(Context context, List<Funcionalidade> funcionalidades) {
        this.context = context;
        this.funcionalidades = funcionalidades;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return funcionalidades.size();
    }

    @Override
    public Object getItem(int position) {
        return funcionalidades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        final ViewHolder holder = new ViewHolder();
        View rowView = view;
        rowView = inflater.inflate(R.layout.item_funcionalidades_list, null);

        holder.txtFuncao = (TextView) rowView.findViewById(R.id.txt_funcionalidade_item);
        holder.imgDetalhes = (ImageView) rowView.findViewById(R.id.img_item_detalhes);

        holder.txtFuncao.setText(funcionalidades.get(position).getNm_funcao());

        holder.imgDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDialog(context, holder.txtFuncao.getText().toString());
            }
        });

        return rowView;
    }

    private class ViewHolder{
        TextView txtFuncao;
        ImageView imgDetalhes;
    }

    public void callDialog(final Context context, String texto){
        new AlertDialog.Builder(context)
                .setTitle("Iniciar Funcionalidade")
                .setMessage("Deseja iniciar " + texto + "?")
                .setCancelable(false)
                .setPositiveButton("Realizar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        ((Activity) context).startActivity(new Intent(context, BiometriaAct.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        ((Activity) context).finish();
                    }
                })
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Implements...
                        dialog.cancel();
                    }
                })
                .create()
                .show();
    }
}
