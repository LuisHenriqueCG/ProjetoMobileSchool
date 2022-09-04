package com.example.a3bimestre.modelo;

public class Turma {
    private int idTurma;
    private String descTurma;
    private int anoInicio;
    private int anoFim;
    private int periodo;

    public  Turma(){

    }

    public Turma(int idTurma, String descTurma, int anoInicio, int anoFim, int periodo) {
        this.idTurma = idTurma;
        this.descTurma = descTurma;
        this.anoInicio = anoInicio;
        this.anoFim = anoFim;
        this.periodo = periodo;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getDescTurma() {
        return descTurma;
    }

    public void setDescTurma(String descTurma) {
        this.descTurma = descTurma;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public int getAnoFim() {
        return anoFim;
    }

    public void setAnoFim(int anoFim) {
        this.anoFim = anoFim;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}
