package DSS.GestPagamentos;

import DSS.GestEquipamentos.Equipamento;
import DSS.GestOrcamentos.Orcamento;

import java.io.Serializable;

public class Pagamento implements Serializable {
    private int nif;
    private double valor;
    private Equipamento eq;

    public Pagamento (int nif, double valor, Equipamento eq) {
        this.nif = nif;
        this.valor = valor;
        this.eq = eq;
    }

    public Pagamento (Pagamento p) {
        this.nif = p.getNif();
        this.valor = p.getValor();
        this.eq = p.getEquipamento();
    }

    public int getNif() {
        return this.nif;
    }
    public double getValor() {
        return valor;
    }

    public Equipamento getEquipamento() {
        return eq.clone();
    }

    public Pagamento clone() {return new Pagamento(this);}
}
