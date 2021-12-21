package DSS.GestOrcamentos;

import DSS.GestEquipamentos.Equipamento;

public class Orcamento {
    private int nif;
    private Equipamento equipamento;
    private int valor;
    //private boolean aceite;

    public Orcamento (int nif, Equipamento eq, int valor) {
        this.nif = nif;
        this.equipamento = eq;
        this.valor = valor;
    }

    public Orcamento(Equipamento eq, int valor) {
        this.nif = eq.getNifCliente();
        this.equipamento = eq.clone();
        this.valor = valor;
    }

    public Orcamento (Equipamento eq) {
        this.nif = eq.getNifCliente();
        this.equipamento = eq;
    }

    public void setValor (int valor) {
        this.valor = valor;
    }

    public Orcamento(Orcamento o) {
        this.nif = o.getNif();
        this.equipamento = o.getEquipamento();
        this.valor = o.getValor();
    }

    public int getNif() {
        return nif;
    }

    public Equipamento getEquipamento() {
        return this.equipamento.clone();
    }

    public int getValor() {
        return this.valor;
    }



    public Orcamento clone() {return new Orcamento(this);}
}
