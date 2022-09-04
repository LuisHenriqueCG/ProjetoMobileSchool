package com.example.a3bimestre.dao;

import com.example.a3bimestre.modelo.Aluno;
import com.example.a3bimestre.modelo.Turma;

import java.util.ArrayList;

public interface GenericDao<Objeto> {

    long insert(Objeto obj);
    long update(Objeto obj);
    long delete(Objeto obj);
    ArrayList<Objeto> getAll();

    Objeto getById(int id);

}
