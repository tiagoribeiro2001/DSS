package DSS.GestPedidosOrcamento;

import DSS.Exceptions.PedidoOrcamentoInexistenteException;
import DSS.GestOrcamentos.GestOrcamentosFacade;

import java.io.Serializable;
import java.util.LinkedList;

public class GestPedidosOrcamentoFacade implements IGestPedidosOrcamentoFacade, Serializable {
    private LinkedList<PedidoOrcamento> pedidosOrcamento;

    public GestPedidosOrcamentoFacade() {this.pedidosOrcamento = new LinkedList<>();}

    public void addPedidoOrcamento(PedidoOrcamento po) {
        this.pedidosOrcamento.add(po.clone());
    }

    public void removePedidoOrcamento () {
        this.pedidosOrcamento.remove();
    }

    public PedidoOrcamento obtemPedido() throws PedidoOrcamentoInexistenteException {
        if (!this.isPedidosOrcamentoEmpty())
            return this.pedidosOrcamento.getFirst();
        throw new PedidoOrcamentoInexistenteException("Erro: Não há pedidos de orçamento.");
    }

    public boolean isPedidosOrcamentoEmpty() {
        return this.pedidosOrcamento.isEmpty();
    }

}
