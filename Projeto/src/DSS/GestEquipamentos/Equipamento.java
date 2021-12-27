package DSS.GestEquipamentos;

import DSS.GestFuncionarios.Funcionario;
import java.io.Serializable;

/**
 * Classe Equipamento usada para representar um equipamento no sistema
 */
public class Equipamento implements Serializable {

    private int nifCliente;
    private String contacto;
    private Funcionario funcionario;
    private boolean repaired;
    private boolean servicoExpresso;
    private double custoReparacao;

    /**
     * Construtor parametrizado da classe Equipamento
     * @param nif Nif do cliente
     * @param fun Funcionário que reparou o equipamento
     * @param cont Contacto do cliente (e-mail)
     * @param expresso Booleano que indica se o serviço realizado foi expresso
     */
    public Equipamento (int nif, Funcionario fun, String cont, boolean expresso) {
        this.nifCliente = nif;
        this.funcionario = fun.clone();
        this.contacto = cont;
        this.repaired = false;
        this.servicoExpresso = expresso;
        this.custoReparacao = 0;
    }

    /**
     * Construtor clone da classe Equipamento
     * @param e Equipamento a ser copiado
     */
    public Equipamento(Equipamento e){
        this.nifCliente = e.getNifCliente();
        this.funcionario = e.getFuncionario();
        this.contacto = e.getContacto();
        this.repaired = e.isRepaired();
        this.servicoExpresso = e.isServicoExpresso();
        this.custoReparacao = e.getCustoReparacao();
    }

    /**
     * Método getter do nif do cliente dono do equipamento
     * @return Nif do cliente
     */
    public int getNifCliente(){
        return this.nifCliente;
    }

    /**
     * Método getter do funcionário que reparou o equipamento
     * @return Funcionário que fez a reparação
     */
    public Funcionario getFuncionario(){
        return this.funcionario.clone();
    }

    /**
     * Método que indica se um equipamento foi reparado
     * @return Booleano que indica se a reparação foi feita
     */
    public boolean isRepaired() {
        return this.repaired;
    }

    /**
     * Método que indica se foi efetuada uma reparação expresso no equipamento
     * @return Booleano que indica se a reparação é expresso
     */
    public boolean isServicoExpresso(){
        return this.servicoExpresso;
    }

    /**
     * Método getter do contacto do dono do equipamento
     * @return Contacto do cliente dono do equipamento
     */
    public String getContacto(){
        return this.contacto;
    }

    /**
     * Método getter do custo da reparação
     * @return Custo da reparação
     */
    public double getCustoReparacao(){
        return this.custoReparacao;
    }

    /**
     * Método que adiciona um valor ao custa da reparação
     * @param custo Valor a adicionar ao custo da reparação
     */
    public void adicionaCustoReparacao(double custo){
        this.custoReparacao += custo;
    }

    /**
     * Método toString da classe Equipamento
     * @return String do Equipamento
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Equipamento {\n");
        sb.append("\tNIF cliente - ").append(nifCliente).append("\n");
        sb.append("\tContacto - ").append(contacto).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Método clone da classe Equipamento
     * @return Equipamento clonado
     */
    public Equipamento clone(){
        return new Equipamento(this);
    }
}
