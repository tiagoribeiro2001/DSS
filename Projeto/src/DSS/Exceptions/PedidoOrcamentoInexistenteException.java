package DSS.Exceptions;

/**
 * Exceção lançada quando não existe um pedido de orçamento no sistema
 */
public class PedidoOrcamentoInexistenteException extends Exception{
    public PedidoOrcamentoInexistenteException (String s) {
        super(s);
    }
}
