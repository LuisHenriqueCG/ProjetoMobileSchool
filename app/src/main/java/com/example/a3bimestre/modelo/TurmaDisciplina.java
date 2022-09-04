package com.example.a3bimestre.modelo;


public class TurmaDisciplina {

    private int idTurma;
    private int idDisciplina;
    private int idTurmaDisciplina;

    public TurmaDisciplina(int idTurma, int idDisciplina, int idTurmaDisciplina) {
        this.idTurma = idTurma;
        this.idDisciplina = idDisciplina;
        this.idTurmaDisciplina = idTurmaDisciplina;
    }

    public TurmaDisciplina() {

    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdTurmaDisciplina() {
        return idTurmaDisciplina;
    }

    public void setIdTurmaDisciplina(int idTurmaDisciplina) {
        this.idTurmaDisciplina = idTurmaDisciplina;
    }
}

