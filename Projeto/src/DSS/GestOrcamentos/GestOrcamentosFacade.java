package DSS.GestOrcamentos;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class GestOrcamentosFacade implements IGestOrcamentosFacade{
    private LinkedHashMap<Integer, Orcamento> orcamentos;

    public GestOrcamentosFacade () {
        this.orcamentos = new LinkedHashMap<>();
    }

    public void addOrcamento (Orcamento o) {
        this.orcamentos.put(o.getNif(), o.clone());
    }

    public LinkedHashMap<Integer, Orcamento> obtemListaOrcamentos () {
        LinkedHashMap<Integer, Orcamento> nova = new LinkedHashMap();
        this.orcamentos.values().forEach(j -> nova.put(j.getNif(), j.clone()));
        return nova;
    }

    public Orcamento obtemOrcamentoMaisAntigo() {
        return this.orcamentos.entrySet().iterator().next().getValue().clone();
    }

    public void removeOrcamentoMaisAntigo() {
        this.orcamentos.remove(this.orcamentos.entrySet().iterator().next().getKey());
    }

    public boolean existeOrcamento (int nif) {
        return this.orcamentos.containsKey(nif);
    }

    public int obtemOrcamento (int nif) {
        return this.orcamentos.get(nif).getValor();
    }
}
