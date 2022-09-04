package com.example.a3bimestre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a3bimestre.helper.SQLiteDataHelper;
import com.example.a3bimestre.modelo.Disciplina;
import com.example.a3bimestre.modelo.Professor;

import java.util.ArrayList;

public class DisciplinaDao implements GenericDao<Disciplina>{

    //Abre a conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase db;

    //nome das colunas da tabela
    private String[]colunas = {"ID_DISCIPLINA", "DESC_DISCIPLINA", "ID_PROFESSOR"};

    //Nome da Tabela
    private String tableName = "DISCIPLINA";

    //Contexto no qual o DAO foi chamado
    private Context context;

    private static DisciplinaDao instancia;

    public static DisciplinaDao getInstance(Context context){
        if (instancia == null)
            return instancia = new DisciplinaDao(context);
        else
            return instancia;
    }

    public DisciplinaDao(Context context) {
        this.context = context;

        //Abrir a conexão com BD
        openHelper = new SQLiteDataHelper(this.context,
                "DISCIPLINA", null, 1);

        db = openHelper.getWritableDatabase(); //Por definição, tudo é bloqueado na base dados, isso faz com que possamos escrever


    }


    @Override
    public long insert(Disciplina obj) {
        ContentValues valores = new ContentValues(); //Um hashMap
        valores.put("ID_DISCIPLINA", obj.getIdDisciplina());
        valores.put("DESC_DISCIPLINA", obj.getDescDisciplina());
        valores.put("ID_PROFESSOR", obj.getIdProfessor());

        return db.insert(tableName, null, valores);
    }

    @Override
    public long update(Disciplina obj) {
        ContentValues valores = new ContentValues();
        valores.put("DESC_DISCIPLINA", obj.getDescDisciplina());

        String[]identificador = {String.valueOf(obj.getIdProfessor())};
        return db.update(tableName, valores,
                "ID_DISCIPLINA = ?", identificador);
    }

    @Override
    public long delete(Disciplina obj) {
        String[]indentificador = {String.valueOf(obj.getIdProfessor())};
        return db.delete(tableName, "ID_DISCIPLINA = ?", indentificador);
    }

    @Override
    public ArrayList<Disciplina> getAll() {
        ArrayList<Disciplina> listaDisciplina = new ArrayList<>();

        Cursor cursor = db.query(tableName, colunas, null, null, null, null, "ID_DISCIPLINA asc"); //selction = where

        if (cursor.moveToFirst()){ //Se ela mover, significa que ha algo dentro dessa pilha
            do {
                Disciplina disciplina = new Disciplina();
                disciplina.setIdDisciplina(cursor.getInt(0));
                disciplina.setDescDisciplina(cursor.getString(1));
                disciplina.setIdProfessor(cursor.getInt(3));
                listaDisciplina.add(disciplina);
            }while (cursor.moveToNext());
        }
        return listaDisciplina;
    }

    @Override
    public Disciplina getById(int id) {
        String[]indentificador = {String.valueOf(id)};
        Cursor cursor = db.query(tableName, colunas,  "ID_DISCIPLINA = ?", indentificador,  null , null , null);
        if (cursor.moveToFirst()){
            Disciplina disciplina = new Disciplina();
            disciplina.setIdDisciplina(cursor.getInt(0));
            disciplina.setDescDisciplina(cursor.getString(1));
            disciplina.setIdProfessor(cursor.getInt(3));
            return disciplina;
        }
        return null;
    }
}
