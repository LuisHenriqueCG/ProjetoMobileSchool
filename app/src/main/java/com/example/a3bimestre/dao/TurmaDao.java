package com.example.a3bimestre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a3bimestre.helper.SQLiteDataHelper;
import com.example.a3bimestre.modelo.Aluno;
import com.example.a3bimestre.modelo.Disciplina;
import com.example.a3bimestre.modelo.Turma;

import java.util.ArrayList;

public class TurmaDao implements GenericDao<Turma> {

    //Abre a conexão com a BD
    private SQLiteOpenHelper openHelper;

    //Base de Dados
    private SQLiteDatabase db;

    //nome das colunas da tabela
    private String[]colunas = {"ID_TURMA", "DESC_TURMA", "ANO_INICIO", "ANO_FIM", "PERIODO"};

    //Nome da Tabela
    private String tableName = "TURMA";

    //Contexto no qual o DAO foi chamado
    private Context context;

    private static TurmaDao instancia;

    public static TurmaDao getInstance(Context context){
        if (instancia == null)
            return instancia = new TurmaDao(context);
        else
            return instancia;
    }

    public TurmaDao(Context context) {
        this.context = context;

        //Abrir a conexão com BD
        openHelper = new SQLiteDataHelper(this.context,
                "TURMA", null, 1);

        db = openHelper.getWritableDatabase(); //Por definição, tudo é bloqueado na base dados, isso faz com que possamos escrever


    }




    @Override
    public long insert(Turma obj) {
        ContentValues valores = new ContentValues(); //Um hashMap
        valores.put("ID_TURMA", obj.getIdTurma());
        valores.put("DESC_TURMA", obj.getDescTurma());
        valores.put("ANO_INICIO", obj.getAnoInicio());
        valores.put("ANO_FIM", obj.getAnoFim());
        valores.put("PERIODO", obj.getPeriodo());

        return db.insert(tableName, null, valores);
    }

    @Override
    public long update(Turma obj) {
        ContentValues valores = new ContentValues();
        valores.put("DESC_TURMA", obj.getDescTurma());

        String[]identificador = {String.valueOf(obj.getIdTurma())};
        return db.update(tableName, valores,
                "ID_TURMA = ?", identificador);
    }

    @Override
    public long delete(Turma obj) {
        String[]indentificador = {String.valueOf(obj.getIdTurma())};
        return db.delete(tableName, "ID_TURMA = ?", indentificador);
    }

    @Override
    public ArrayList<Turma> getAll() {
        ArrayList<Turma> listaTurma = new ArrayList<>();

        Cursor cursor = db.query(tableName, colunas, null, null, null, null, "ID_TURMA asc"); //selction = where

        if (cursor.moveToFirst()){ //Se ela mover, significa que ha algo dentro dessa pilha
            do {
                Turma turma = new Turma();
                turma.setIdTurma(cursor.getInt(0));
                turma.setDescTurma(cursor.getString(1));
                turma.setAnoInicio(cursor.getInt(2));
                turma.setAnoFim(cursor.getInt(3));
                turma.setPeriodo(cursor.getInt(4));
                listaTurma.add(turma);
            }while (cursor.moveToNext());
        }
        return listaTurma;
    }

    @Override
    public Turma getById(int id) {
        String[]indentificador = {String.valueOf(id)};
        Cursor cursor = db.query(tableName, colunas,  "ID_TURMA = ?", indentificador,  null , null , null);
        if (cursor.moveToFirst()){
            Turma turma = new Turma();
            turma.setIdTurma(cursor.getInt(0));
            turma.setDescTurma(cursor.getString(1));
            turma.setAnoInicio(cursor.getInt(2));
            turma.setAnoFim(cursor.getInt(3));
            turma.setPeriodo(cursor.getInt(4));
            return turma;
        }
        return null;

    }
}
