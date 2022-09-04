package com.example.a3bimestre.controller;

import android.content.Context;

import com.example.a3bimestre.dao.AlunoDao;
import com.example.a3bimestre.dao.DisciplinaDao;
import com.example.a3bimestre.modelo.Aluno;
import com.example.a3bimestre.modelo.Disciplina;

import java.util.ArrayList;

public class DisciplinaController {
    private Context context;
    public DisciplinaController(Context context) {
        this.context = context;
    }

    public ArrayList<Disciplina> retornaDisciplina(){
        return DisciplinaDao.getInstance(context).getAll();
    }

    public long salvarDisciplina(Disciplina disciplina){
        return DisciplinaDao.getInstance(context).insert(disciplina);
    }
}
