package com.example.a3bimestre.controller;


import android.content.Context;

import com.example.a3bimestre.dao.DisciplinaDao;
import com.example.a3bimestre.dao.ProfessorDao;
import com.example.a3bimestre.modelo.Disciplina;
import com.example.a3bimestre.modelo.Professor;

import java.util.ArrayList;

public class ProfessorController {
    private Context context;
    public ProfessorController(Context context) {
        this.context = context;
    }

    public ArrayList<Professor> retornaProfessor(){
        return ProfessorDao.getInstance(context).getAll();
    }

    public long salvarProfessor(Professor professor){
        return ProfessorDao.getInstance(context).insert(professor);
    }
}

