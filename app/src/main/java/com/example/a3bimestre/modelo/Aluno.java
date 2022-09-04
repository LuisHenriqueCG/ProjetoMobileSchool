package com.example.a3bimestre.modelo;

import java.util.Date;

public class Aluno {

    private int raAluno;
    private String nomeAluno;
    private int cpfAluno;
    private int rgAluno;
    private String dtMatriculaAluno;
    private int idTurmaAluno;

    public Aluno(){

    }
    public Aluno(int raAluno, String nomeAluno, int cpfAluno, int rgAluno, String dtMatriculaAluno, int idTurmaAluno) {
        this.raAluno = raAluno;
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.rgAluno = rgAluno;
        this.dtMatriculaAluno = dtMatriculaAluno;
        this.idTurmaAluno = idTurmaAluno;
    }

    public int getRaAluno() { return raAluno; }

    public void setRaAluno(int raAluno) {
        this.raAluno = raAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public int getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(int cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public int getRgAluno() {
        return rgAluno;
    }

    public void setRgAluno(int rgAluno) {
        this.rgAluno = rgAluno;
    }

    public String getDtMatriculaAluno() {
        return dtMatriculaAluno;
    }

    public void setDtMatriculaAluno(String dtMatriculaAluno) {
        this.dtMatriculaAluno = dtMatriculaAluno;
    }

    public int getIdTurmaAluno() {
        return idTurmaAluno;
    }

    public void setIdTurmaAluno(int idTurmaAluno) {
        this.idTurmaAluno = idTurmaAluno;
    }
}