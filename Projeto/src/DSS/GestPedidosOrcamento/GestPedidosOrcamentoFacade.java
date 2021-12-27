package DSS.GestPedidosOrcamento;

import DSS.Exceptions.PedidoOrcamentoInexistenteException;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Classe GestPedidoOrcamentoFacade usada para representar uma coleção de pedidos de orçamento no sistema
 */
public class GestPedidosOrcamentoFacade implements IGestPedidosOrcamentoFacade, Serializable{
    private LinkedList<PedidoOrcamento> pedidosOrcamento;

    public GestPedidosOrcamentoFacade(){
        this.pedidosOrcamento = new LinkedList<>();
    }

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
