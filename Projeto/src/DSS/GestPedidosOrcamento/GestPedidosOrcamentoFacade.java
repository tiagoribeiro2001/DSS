package DSS.GestPedidosOrcamento;

import DSS.GestOrcamentos.GestOrcamentosFacade;

import java.util.LinkedList;

public class GestPedidosOrcamentoFacade implements IGestPedidosOrcamentoFacade{
    private LinkedList<PedidoOrcamento> pedidosOrcamento;

    public GestPedidosOrcamentoFacade() {this.pedidosOrcamento = new LinkedList<>();}

    public void addPedidoOrcamento(PedidoOrcamento po) {
        this.pedidosOrcamento.add(po.clone());
    }

    public void removePedidoOrcamento () {
        this.pedidosOrcamento.remove();
    }

    public PedidoOrcamento obtemPedido() {
        return this.pedidosOrcamento.getFirst();
    }

    public boolean isPedidosOrcamentoEmpty() {
        return this.pedidosOrcamento.isEmpty();
    }

}
