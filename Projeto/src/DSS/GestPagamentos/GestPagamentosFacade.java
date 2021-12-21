package DSS.GestPagamentos;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GestPagamentosFacade implements IGestPagamentosFacade, Serializable {
    private Map<Integer, Pagamento> pagamentos;

    public GestPagamentosFacade() {
        this.pagamentos = new HashMap<>();
    }

    public void addPagamento(Pagamento p) {
        this.pagamentos.put(p.getNif(), p.clone());
    }
}
