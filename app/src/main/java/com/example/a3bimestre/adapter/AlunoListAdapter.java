package com.example.a3bimestre.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3bimestre.R;
import com.example.a3bimestre.controller.AlunoController;
import com.example.a3bimestre.modelo.Aluno;

import java.util.ArrayList;

public class AlunoListAdapter extends BaseAdapter {

    private ArrayList<Aluno> listaAluno;
    private Context context;
    private AlertDialog alertDialog;
    private AlunoListAdapter alunoListAdapter;
    private AlunoController controller;

    public AlunoListAdapter(ArrayList<Aluno> listaAluno,
                            Context context) {
        this.listaAluno = listaAluno;
        this.context = context;
        alunoListAdapter = this;
        controller = new AlunoController(context);
    }

    @Override
    public int getCount() {
        return listaAluno.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAluno.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null){
            view = LayoutInflater.from(context).inflate
                    (R.layout.aluno_list_item, viewGroup,
                            false);
        }

        TextView tvRaAluno = view.findViewById(R.id.tvRaAluno);
        TextView tvNomeAluno = view.findViewById(R.id.tvRaAluno);
        ImageButton btExcluir = view.findViewById(R.id.btExcluir);
        Aluno aluno = listaAluno.get(position);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(aluno);
            }
        });


        tvRaAluno.setText(String.valueOf(aluno.getRaAluno()));
        tvNomeAluno.setText(String.valueOf(aluno.getNomeAluno()));


        return view;
    }

    public void showDialog(Aluno aluno){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //SETANDO PARA NÃO FECHAR QUANDO EU CLICAR EM CIMA DELE
        builder.setCancelable(false);

        //SETANDO O TITULO
        builder.setTitle("Excluir");
        //SETANDO O ICONE
        builder.setIcon(context.getResources()
                .getDrawable(R.drawable.ic_excluir));
        builder.setMessage("Deseja excluir o registro do Aluno: "
        +aluno.getNomeAluno()+" ?");
        //SETANDO OS BOTÕES DO DIALOG
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Aqui vai o método de excluir o aluno
                if (controller.excluirAluno(aluno) > 0){
                    listaAluno.remove(aluno);
                    alunoListAdapter.notifyDataSetChanged();
                    Toast.makeText(context,
                            "Aluno excluído com sucesso! ",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,
                            "Erro ao excluír Aluno! ",
                            Toast.LENGTH_LONG).show();
                }


            }
        });

        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Aqui vai fechar o Dialog
                alertDialog.dismiss();
            }
        });

        alertDialog = builder.create();
        alertDialog.show();
    }
}
