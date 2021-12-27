package DSS.GestOrcamentos;

import DSS.GestEquipamentos.Equipamento;
import java.io.Serializable;

/**
 * Classe Orcamento usada para representar um orçamento de uma reparação no sistema
 */
public class Orcamento implements Serializable{
    private int nif;
    private Equipamento equipamento;
    private double valor;
    String problema;

    /**
     * Construtor parametrizado da classe Orcamento
     * @param nif Nif do dono do Equipamento
     * @param eq Equipamento a ser reparado
     * @param valor Custo da reparação
     * @param problema Problema que leva à reparação
     */
    public Orcamento(int nif, Equipamento eq, int valor, String problema){
        this.nif = nif;
        this.equipamento = eq;
        this.valor = valor;
        this.problema = problema;
    }

    /**
     * Constutor parametrizado da classe Orcamento
     * @param eq Equipamento a ser reparado
     * @param valor Custo da reparação
     * @param problema Problema que leva à reparação
     */
    public Orcamento(Equipamento eq, int valor, String problema){
        this.nif = eq.getNifCliente();
        this.equipamento = eq.clone();
        this.valor = valor;
        this.problema = problema;
    }

    /**
     *  Constutor parametrizado da classe Orcamento
     * @param eq Equipamento a ser reparado
     * @param valor Custo da reparação
     */
    public Orcamento(Equipamento eq, int valor){
        this.nif = eq.getNifCliente();
        this.equipamento = eq.clone();
        this.valor = valor;
        this.problema = "";
    }

    /**
     * Construtor paramentrizado da classe Orcamento
     * @param eq Equipamento a ser reparado
     */
    public Orcamento (Equipamento eq) {
        this.nif = eq.getNifCliente();
        this.equipamento = eq;
        this.problema = "";
    }

    /**
     * Método setter do custo da reparação
     * @param valor Custo da reparação
     */
    public void setValor(double valor){
        this.valor = valor;
    }

    /**
     * Método getter do problema que leva À reparação
     * @return String que descreve o problema
     */
    public String getProblema(){
        return this.problema;
    }

    /**
     * Construtor clone da classe Orcamento
     * @param o Orcamento a ser copiado
     */
    public Orcamento(Orcamento o) {
        this.nif = o.getNif();
        this.equipamento = o.getEquipamento();
        this.valor = o.getValor();
        this.problema = o.getProblema();
    }

    /**
     * Método setter do problema que leva à reparação
     * @param problema String que descreve o problema
     */
    public void setProblema (String problema) {
        this.problema = problema;
    }

    /**
     * Método getter do nif do dono do Equipamento
     * @return Nif do dono do equipametno
     */
    public int getNif() {
        return nif;
    }

    /**
     * Método getter do Equipamento a que se refere o Orcamento
     * @return Equipamento a que se refero o Orcamento
     */
    public Equipamento getEquipamento() {
        return this.equipamento.clone();
    }

    /**
     * Método getter do valor da reparação do Equipamento
     * @return Custo da reparação
     */
    public double getValor() {
        return this.valor;
    }

    /**
     * Método toString da classe Orcamento
     * @return String do Orcamento
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Problema: ").append(this.problema).append("\n");
        sb.append("ID: ").append(this.equipamento.getNifCliente()).append("\n");
        return sb.toString();
    }

    /**
     * Método clone da classe Orcamento
     * @return Orcamento clonado
     */
    public Orcamento clone(){
        return new Orcamento(this);
    }
}
