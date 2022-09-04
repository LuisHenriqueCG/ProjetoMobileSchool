package com.example.a3bimestre.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {

    public SQLiteDataHelper(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
    }


    //Esse método é executado uma única vez
    //quando é instalado o aplicativo
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE ALUNO" +
                "(RA_ALUNO INTEGER, NOME_ALUNO VARCHAR(100), CPF_ALUNO, RG_ALUNO," +
                "DT_MATRICULA_ALUNO, ID_TURMA_ALUNO)");

    }

    //Esse método é executa quando é atualizado a versão do aplicativo
    //Atualiza as tabelas de acordo com a nova versão
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int oldVersion, int newVersion) {

    }
}
