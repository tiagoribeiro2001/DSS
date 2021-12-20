package DSS.GestPagamentos;

import DSS.GestEquipamentos.Equipamento;
import DSS.GestOrcamentos.Orcamento;

public class Pagamento {
    private int nif;
    private int valor;
    private Equipamento eq;

    public Pagamento (int nif, int valor, Equipamento eq) {
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
    public int getValor() {
        return valor;
    }

    public Equipamento getEquipamento() {
        return eq.clone();
    }

    public Pagamento clone() {return new Pagamento(this);}
}
