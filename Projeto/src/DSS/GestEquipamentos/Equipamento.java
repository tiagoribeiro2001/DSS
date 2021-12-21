package DSS.GestEquipamentos;

import DSS.GestFuncionarios.Funcionario;

import java.io.Serializable;

public class Equipamento implements Serializable {

    private int nifCliente;
    private String contacto;
    private Funcionario funcionario;
    private boolean repaired;
    private boolean servicoExpresso;
    private double custoReparacao;

    public Equipamento (int nif, Funcionario fun, String cont, boolean expresso) {
        this.nifCliente = nif;
        this.funcionario = fun.clone();
        this.contacto = cont;
        this.repaired = false;
        this.servicoExpresso = expresso;
        this.custoReparacao = 0;
    }

    public Equipamento(Equipamento e) {
        this.nifCliente = e.getNifCliente();
        this.funcionario = e.getFuncionario();
        this.contacto = e.getContacto();
        this.repaired = e.isRepaired();
        this.servicoExpresso = e.isServicoExpresso();
        this.custoReparacao = e.getCustoReparacao();
    }

    public int getNifCliente(){return this.nifCliente;}
    public Funcionario getFuncionario(){return this.funcionario.clone();}
    public boolean isRepaired() {return this.repaired;}
    public boolean isServicoExpresso(){return this.servicoExpresso;}
    public String getContacto() {return this.contacto;}
    public double getCustoReparacao () {return this.custoReparacao;}

    public void adicionaCustoReparacao(double custo) {
        this.custoReparacao += custo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Equipamento {\n");
        sb.append("\tNIF cliente - ").append(nifCliente).append("\n");
        sb.append("\tContacto - ").append(contacto).append("\n");
        sb.append("}");
        return sb.toString();
    }



    public Equipamento clone () {return new Equipamento(this);}
}
