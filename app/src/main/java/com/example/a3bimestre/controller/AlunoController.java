package com.example.a3bimestre.controller;

import android.content.Context;

import com.example.a3bimestre.dao.AlunoDao;
import com.example.a3bimestre.modelo.Aluno;

import java.util.ArrayList;

public class AlunoController {

    private Context context;

    public AlunoController(Context context) {
        this.context = context;
    }

    public ArrayList<Aluno> retornaAlunos(){
       return AlunoDao.getInstancia(context).getAll();
    }

    public long salvarAluno(Aluno aluno){
        return AlunoDao.getInstancia(context).insert(aluno);
    }

    public long excluirAluno(Aluno aluno){
        return AlunoDao.getInstancia(context).delete(aluno);
    }

}
