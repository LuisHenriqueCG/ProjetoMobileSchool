package com.example.a3bimestre.controller;

import android.content.Context;

import com.example.a3bimestre.dao.ProfessorDao;
import com.example.a3bimestre.dao.TurmaDisciplinaDao;
import com.example.a3bimestre.modelo.Professor;
import com.example.a3bimestre.modelo.TurmaDisciplina;

import java.util.ArrayList;

public class TurmaDisciplinaController {

    private Context context;
    public TurmaDisciplinaController(Context context) {
        this.context = context;
    }

    public ArrayList<TurmaDisciplina> retornaTurmaDisciplina(){
        return TurmaDisciplinaDao.getInstance(context).getAll();
    }

    public long salvarProfessor(TurmaDisciplina turmaDisciplina){
        return TurmaDisciplinaDao.getInstance(context).insert(turmaDisciplina);
    }
}

