package DSS.GestPagamentos;

import java.util.HashMap;
import java.util.Map;

public class GestPagamentosFacade implements IGestPagamentosFacade{
    private Map<Integer, Pagamento> pagamentos;

    public GestPagamentosFacade() {
        this.pagamentos = new HashMap<>();
    }

    public void addPagamento(Pagamento p) {
        this.pagamentos.put(p.getNif(), p.clone());
    }
}
