package com.example.a3bimestre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a3bimestre.helper.SQLiteDataHelper;
import com.example.a3bimestre.modelo.Aluno;

import java.util.ArrayList;

public class AlunoDao implements  GenericDao<Aluno>{

    //Abrir conexão com a base de dado

    private SQLiteOpenHelper openHelper;

    //Base de Dados

    private SQLiteDatabase db;

    //Nome das Colunas da Tabela
    private String[]colunas = {"RA_ALUNO", "NOME_ALUNO", "CPF_ALUNO", "RA_ALUNO", "DT_MATRICULA_ALUNO",
    "ID_TURMA_ALUNO"};

    //Nome da Tabela
    private String tableName = "ALUNO";

    //Contexto no qual o DAO Foi Chamado
    private Context context;

    private static AlunoDao instancia;

    public static AlunoDao getInstancia(Context context){
        if(instancia == null)
            return instancia = new AlunoDao(context);
        else
            return instancia;
    }

    //Construtor
    private AlunoDao(Context context) {
        this.context = context;

        //Abrir a conexão com a base de dados

        openHelper = new SQLiteDataHelper(this.context, "UNIPAR",
        null, 1);

        db = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Aluno obj) {
        ContentValues valores = new ContentValues();
        valores.put("RA_ALUNO", obj.getRaAluno());
        valores.put("NOME_ALUNO", obj.getNomeAluno());
        valores.put("CPF_ALUNO", obj.getCpfAluno());
        valores.put("RG_ALUNO", obj.getRgAluno());
        valores.put("DT_MATRICULA_ALUNO", obj.getDtMatriculaAluno());
        valores.put("ID_TURMA_ALUNO", obj.getIdTurmaAluno());


        return db.insert(tableName, null, valores);

    }

    @Override
    public long update(Aluno obj) {
        ContentValues valores = new ContentValues();
        valores.put("NOME_ALUNO", obj.getNomeAluno());
        valores.put("RA_ALUNO", obj.getRaAluno());
        valores.put("CPF_ALUNO", obj.getCpfAluno());
        valores.put("RG_ALUNO", obj.getRgAluno());
        valores.put("DT_MATRICULA_ALUNO", obj.getDtMatriculaAluno());
        valores.put("ID_TURMA_ALUNO", obj.getIdTurmaAluno());

        String[]identificador = {String.valueOf(obj.getRaAluno())};
        return db.update(tableName, valores,
                "RA_ALUNO = ?", identificador);
    }

    // ? = Esperando parâmetro
    @Override
    public long delete(Aluno obj) {
            String[]identificador = {String.valueOf(obj.getRaAluno())};
        return db.delete(tableName, "RA_ALUNO = ?",identificador);
    }

    @Override
    public ArrayList<Aluno> getAll() {
        ArrayList<Aluno> listaAluno = new ArrayList<>();

        Cursor cursor = db.query(tableName, colunas,
                null, null, null,
                null, "RA_ALUNO asc");

        if(cursor.moveToFirst()){
            do {
                Aluno aluno = new Aluno();
                aluno.setRaAluno(cursor.getInt(0));
                aluno.setNomeAluno(cursor.getString(1));

                listaAluno.add(aluno);

            }while (cursor.moveToNext());
        }

        return listaAluno;
    }

    @Override
    public Aluno getById(int id) {
        String[]identificador = {String.valueOf(id)};

        Cursor cursor = db.query(tableName, colunas,
                "RA_ALUNO = ?", identificador, null, null,
                null);

        if (cursor.moveToFirst()){
            Aluno aluno = new Aluno();
            aluno.setRaAluno(cursor.getInt(0));
            aluno.setNomeAluno(cursor.getString(1));

            return aluno;
        }

        return null;
    }
}
