package com.example.a3bimestre.modelo;

public class Disciplina {
    private int idDisciplina;
    private String descDisciplina;
    private int idProfessor;

    public Disciplina(){}

    public Disciplina(int idDisciplina, String descDisciplina, int idProfessor) {
        this.idDisciplina = idDisciplina;
        this.descDisciplina = descDisciplina;
        this.idProfessor = idProfessor;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getDescDisciplina() {
        return descDisciplina;
    }

    public void setDescDisciplina(String descDisciplina) {
        this.descDisciplina = descDisciplina;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
