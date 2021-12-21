package DSS.GestOrcamentos;

import DSS.GestEquipamentos.Equipamento;

import java.io.Serializable;

public class Orcamento implements Serializable {
    private int nif;
    private Equipamento equipamento;
    private double valor;
    String problema;

    public Orcamento (int nif, Equipamento eq, int valor, String problema) {
        this.nif = nif;
        this.equipamento = eq;
        this.valor = valor;
        this.problema = problema;
    }

    public Orcamento(Equipamento eq, int valor, String problema) {
        this.nif = eq.getNifCliente();
        this.equipamento = eq.clone();
        this.valor = valor;
        this.problema = problema;
    }

    public Orcamento(Equipamento eq, int valor) {
        this.nif = eq.getNifCliente();
        this.equipamento = eq.clone();
        this.valor = valor;
        this.problema = "";
    }

    public Orcamento (Equipamento eq) {
        this.nif = eq.getNifCliente();
        this.equipamento = eq;
        this.problema = "";
    }

    public void setValor (double valor) {
        this.valor = valor;
    }

    public String getProblema() {
        return this.problema;
    }
    public Orcamento(Orcamento o) {
        this.nif = o.getNif();
        this.equipamento = o.getEquipamento();
        this.valor = o.getValor();
        this.problema = o.getProblema();
    }

    public void setProblema (String problema) {
        this.problema = problema;
    }

    public int getNif() {
        return nif;
    }

    public Equipamento getEquipamento() {
        return this.equipamento.clone();
    }

    public double getValor() {
        return this.valor;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Problema: ").append(this.problema).append("\n");
        sb.append("ID: ").append(this.equipamento.getNifCliente()).append("\n");
        return sb.toString();
    }


    public Orcamento clone() {return new Orcamento(this);}
}
