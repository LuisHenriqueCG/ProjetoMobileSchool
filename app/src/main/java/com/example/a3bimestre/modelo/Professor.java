package com.example.a3bimestre.modelo;


public class Professor {
    private int idProfessor;
    private String nomeProfessor;
    private int matricula;

    public Professor() {

    }

    public Professor(int idProfessor, String nomeProfessor, int matricula) {
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
        this.matricula = matricula;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
