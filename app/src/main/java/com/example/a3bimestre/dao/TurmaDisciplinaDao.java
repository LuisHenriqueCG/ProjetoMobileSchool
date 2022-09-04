package com.example.a3bimestre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a3bimestre.helper.SQLiteDataHelper;
import com.example.a3bimestre.modelo.Turma;
import com.example.a3bimestre.modelo.TurmaDisciplina;

import java.util.ArrayList;

public class TurmaDisciplinaDao implements GenericDao<TurmaDisciplina> {

    //Abre a conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase db;

    //nome das colunas da tabela
    private String[]colunas = {"ID_TURMA", "ID_DISCIPLINA"};

    //Nome da Tabela
    private String tableName = "TURMADISCIPLINA";

    //Contexto no qual o DAO foi chamado
    private Context context;

    private static TurmaDisciplinaDao instancia;

    public static TurmaDisciplinaDao getInstance(Context context){
        if (instancia == null)
            return instancia = new TurmaDisciplinaDao(context);
        else
            return instancia;
    }

    public TurmaDisciplinaDao(Context context) {
        this.context = context;

        //Abrir a conexão com BD
        openHelper = new SQLiteDataHelper(this.context,
                "TURMADISCIPLINA", null, 1);

        db = openHelper.getWritableDatabase(); //Por definição, tudo é bloqueado na base dados, isso faz com que possamos escrever


    }
    @Override
    public long insert(TurmaDisciplina obj) {
        ContentValues valores = new ContentValues(); //Um hashMap
        valores.put("ID_TURMA", obj.getIdTurma());
        valores.put("ID_DISCIPLINA", obj.getIdDisciplina());

        return db.insert(tableName, null, valores);
    }

    @Override
    public long update(TurmaDisciplina obj) {
        ContentValues valores = new ContentValues();
        valores.put("ID_TURMADISCIPLINA", obj.getIdTurma());

        String[]identificador = {String.valueOf(obj.getIdTurma())};
        return db.update(tableName, valores,
                "ID_TURMADISCIPLINA = ?", identificador);
    }

    @Override
    public long delete(TurmaDisciplina obj) {
        String[]indentificador = {String.valueOf(obj.getIdTurma())};
        return db.delete(tableName, "ID_TURMADISCIPLINA = ?", indentificador);
    }

    @Override
    public ArrayList<TurmaDisciplina> getAll() {
        ArrayList<TurmaDisciplina> listaTurmaDisciplina = new ArrayList<>();

        Cursor cursor = db.query(tableName, colunas, null, null, null, null, "ID_TURMA asc"); //selction = where

        if (cursor.moveToFirst()){ //Se ela mover, significa que ha algo dentro dessa pilha
            do {
                TurmaDisciplina turmaDisciplina = new TurmaDisciplina();
                turmaDisciplina.setIdTurmaDisciplina(cursor.getInt(0));
                turmaDisciplina.setIdTurma(cursor.getInt(1));
                turmaDisciplina.setIdDisciplina(cursor.getInt(2));
                listaTurmaDisciplina.add(turmaDisciplina);
            }while (cursor.moveToNext());
        }
        return listaTurmaDisciplina;
    }

    @Override
    public TurmaDisciplina getById(int id) {
        String[]indentificador = {String.valueOf(id)};
        Cursor cursor = db.query(tableName, colunas,  "ID_TURMA = ?", indentificador,  null , null , null);
        if (cursor.moveToFirst()){
            TurmaDisciplina turmaDisciplina = new TurmaDisciplina();
            turmaDisciplina.setIdTurmaDisciplina(cursor.getInt(0));
            turmaDisciplina.setIdTurma(cursor.getInt(1));
            turmaDisciplina.setIdDisciplina(cursor.getInt(2));
            return turmaDisciplina;
        }
        return null;
    }
}
