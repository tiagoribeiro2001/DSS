package DSS.GestPedidosOrcamento;

public interface IGestPedidosOrcamentoFacade{
    void removePedidoOrcamento ();
    void addPedidoOrcamento(PedidoOrcamento po);
    PedidoOrcamento obtemPedido();
    boolean isPedidosOrcamentoEmpty();
}
