package DSS.Exceptions;

import DSS.GestPedidosOrcamento.PedidoOrcamento;

public class PedidoOrcamentoInexistenteException extends Exception{
    public PedidoOrcamentoInexistenteException (String s) {
        super(s);
    }
}
