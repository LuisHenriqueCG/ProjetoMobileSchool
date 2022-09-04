package com.example.a3bimestre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a3bimestre.helper.SQLiteDataHelper;
import com.example.a3bimestre.modelo.Aluno;
import com.example.a3bimestre.modelo.Professor;

import java.util.ArrayList;

public class ProfessorDao implements  GenericDao<Professor>{

    //Abre a conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase db;

    //nome das colunas da tabela
    private String[]colunas = {"ID_PROFESSOR", "NOME_PROFESSOR", "MATRICULA"};

    //Nome da Tabela
    private String tableName = "PROFESSOR";

    //Contexto no qual o DAO foi chamado
    private Context context;

    private static ProfessorDao instancia;

    public static ProfessorDao getInstance(Context context){
        if (instancia == null)
            return instancia = new ProfessorDao(context);
        else
            return instancia;
    }

    public ProfessorDao(Context context) {
        this.context = context;

        //Abrir a conexão com BD
        openHelper = new SQLiteDataHelper(this.context,
                "PROFESSOR", null, 1);

        db = openHelper.getWritableDatabase(); //Por definição, tudo é bloqueado na base dados, isso faz com que possamos escrever


    }

    @Override
    public long insert(Professor obj) {
        ContentValues valores = new ContentValues(); //Um hashMap
        valores.put("ID_PROFESSOR", obj.getIdProfessor());
        valores.put("NOME_PROFESSOR", obj.getNomeProfessor());
        valores.put("NOME_MATRICULA", obj.getMatricula());

        return db.insert(tableName, null, valores);
    }

    @Override
    public long update(Professor obj) {
        ContentValues valores = new ContentValues();
        valores.put("NOME_PROFESSOR", obj.getNomeProfessor());

        String[]identificador = {String.valueOf(obj.getIdProfessor())};
        return db.update(tableName, valores,
                "ID_PROFESSOR = ?", identificador); // ? significa que é uma paramentro esperado

    }

    @Override
    public long delete(Professor obj) {
        String[]indentificador = {String.valueOf(obj.getIdProfessor())};
        return db.delete(tableName, "ID_PROFESSOR = ?", indentificador);
    }

    @Override
    public ArrayList<Professor> getAll() {
        ArrayList<Professor> listaProfessor = new ArrayList<>();

        Cursor cursor = db.query(tableName, colunas, null, null, null, null, "ID_PROFESSOR asc"); //selction = where

        if (cursor.moveToFirst()){ //Se ela mover, significa que ha algo dentro dessa pilha
            do {
                Professor professor = new Professor();
                professor.setIdProfessor(cursor.getInt(0));
                professor.setNomeProfessor(cursor.getString(1));
                professor.setMatricula(cursor.getInt(3));
                listaProfessor.add(professor);
            }while (cursor.moveToNext());
        }
        return listaProfessor;
    }

    @Override
    public Professor getById(int id) {
        String[]indentificador = {String.valueOf(id)};
        Cursor cursor = db.query(tableName, colunas,  "ID_PROFESSOR = ?", indentificador,  null , null , null);
        if (cursor.moveToFirst()){
            Professor professor = new Professor();
            professor.setIdProfessor(cursor.getInt(0));
            professor.setNomeProfessor(cursor.getString(1));
            professor.setMatricula(cursor.getInt(3));
            return professor;
        }
        return null;
    }

}

