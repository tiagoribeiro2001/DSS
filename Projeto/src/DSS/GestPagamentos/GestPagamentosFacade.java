package DSS.GestPagamentos;

import DSS.GestEquipamentos.Equipamento;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe GestPagamentosFacade usada para representar uma coleção de Pagamentos no sistema
 */
public class GestPagamentosFacade implements IGestPagamentosFacade, Serializable {
    private Map<Integer, Pagamento> pagamentos;

    public GestPagamentosFacade(){
        this.pagamentos = new HashMap<>();
    }

    public void addPagamento(int nif, double valor, Equipamento equip){
        Pagamento pag = new Pagamento(nif, valor, equip.clone());
        this.pagamentos.put(pag.getNif(), pag);
    }
}
