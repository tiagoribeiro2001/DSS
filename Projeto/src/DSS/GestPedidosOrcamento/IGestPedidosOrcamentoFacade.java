package DSS.GestPedidosOrcamento;

import DSS.Exceptions.PedidoOrcamentoInexistenteException;

public interface IGestPedidosOrcamentoFacade{
    void removePedidoOrcamento ();
    void addPedidoOrcamento(PedidoOrcamento po);
    PedidoOrcamento obtemPedido() throws PedidoOrcamentoInexistenteException;
    boolean isPedidosOrcamentoEmpty();
}
