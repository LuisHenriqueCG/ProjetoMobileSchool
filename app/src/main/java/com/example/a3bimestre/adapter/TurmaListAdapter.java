package com.example.a3bimestre.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.a3bimestre.R;
import com.example.a3bimestre.modelo.Aluno;
import com.example.a3bimestre.modelo.Turma;

import java.util.ArrayList;

public class TurmaListAdapter extends BaseAdapter {

    private ArrayList<Turma> listaTurma;
    private Context context;

    public TurmaListAdapter(ArrayList<Turma> listaTurma,
                            Context context) {
        this.listaTurma = listaTurma;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaTurma.size();
    }

    @Override
    public Object getItem(int position) {
        return listaTurma.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }


}
