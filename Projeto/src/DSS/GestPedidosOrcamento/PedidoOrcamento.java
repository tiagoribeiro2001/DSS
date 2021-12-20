package DSS.GestPedidosOrcamento;

import DSS.GestEquipamentos.Equipamento;

public class PedidoOrcamento {

    private Equipamento equipamento;
    private String problema;

    public PedidoOrcamento (Equipamento eq, String problema) {
        this.equipamento = eq;
        this.problema = problema;
    }

    public PedidoOrcamento (PedidoOrcamento po) {
        this.equipamento = po.getEquipamento();
        this.problema = po.getProblema();
    }

    public Equipamento getEquipamento() {
        return this.equipamento.clone();
    }

    public String getProblema() {
        return this.problema;
    }

    public PedidoOrcamento clone() {return new PedidoOrcamento(this);}
}
