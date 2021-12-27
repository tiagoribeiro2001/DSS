package DSS.GestPagamentos;

import DSS.GestEquipamentos.Equipamento;
import java.io.Serializable;

/**
 * Classe Pagamento usada para representar o pagamento de uma reparação no sistema
 */
public class Pagamento implements Serializable{
    private int nif;
    private double valor;
    private Equipamento eq;

    /**
     * Construtor parametrizado da classe Pagamento
     * @param nif Nif do dono do Equipamento
     * @param valor Custo da reparação
     * @param eq Equipamento a ser reparado
     */
    public Pagamento(int nif, double valor, Equipamento eq){
        this.nif = nif;
        this.valor = valor;
        this.eq = eq;
    }

    /**
     * Construtor clone da classe Pagamento
     * @param p Pagamento a ser copiado
     */
    public Pagamento (Pagamento p) {
        this.nif = p.getNif();
        this.valor = p.getValor();
        this.eq = p.getEquipamento();
    }

    /**
     * Método getter do nif do dono do Equipamento
     * @return Nif do dono do equipamento
     */
    public int getNif(){
        return this.nif;
    }

    /**
     * Método getter do valor da reparação do Equipamento
     * @return Custo da reparação
     */
    public double getValor(){
        return valor;
    }

    /**
     * Método getter do Equipamento a que se refere o Pagamento
     * @return Equipamento a que se refere o Pagamento
     */
    public Equipamento getEquipamento(){
        return eq.clone();
    }

    /**
     * Método clone da classe Pagamento
     * @return Pagamento clonado
     */
    public Pagamento clone(){
        return new Pagamento(this);
    }
}
