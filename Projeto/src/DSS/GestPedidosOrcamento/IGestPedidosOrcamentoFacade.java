package DSS.GestPedidosOrcamento;

import DSS.Exceptions.PedidoOrcamentoInexistenteException;

/**
 * Interface IGestPedidosOrcamento que contém os seguintes métodos
 */
public interface IGestPedidosOrcamentoFacade{
    /**
     * Método que remove um pedido de orçamento do sistema
     */
    void removePedidoOrcamento();

    /**
     * Método que adiciona um pedido de orçamento ao sistema
     * @param po PedidoOrcamento a ser adicionado
     */
    void addPedidoOrcamento(PedidoOrcamento po);

    /**
     * Método que obtém o pedido de orçamento que está à mais tempo no sistema
     * @return PedidoOrcamento à mais tempo no sistema
     * @throws PedidoOrcamentoInexistenteException Exceção lançada quando não existe nenhum pedido de orçamento no sistema
     */
    PedidoOrcamento obtemPedido() throws PedidoOrcamentoInexistenteException;

    /**
     * Método que verifica se a lista de pedidos de orçamento está vazia
     * @return Booleano que indica se a lista está vazia
     */
    boolean isPedidosOrcamentoEmpty();
}
