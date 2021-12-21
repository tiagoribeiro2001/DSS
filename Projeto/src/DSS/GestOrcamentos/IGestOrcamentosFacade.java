package DSS.GestOrcamentos;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public interface IGestOrcamentosFacade {
    void addOrcamento (Orcamento o);
    LinkedHashMap<Integer, Orcamento> obtemListaOrcamentos ();
    public Orcamento obtemOrcamentoMaisAntigo();
    public void removeOrcamentoMaisAntigo();
    double obtemOrcamento (int nif);
    boolean existeOrcamento (int nif);
    Orcamento getOrcamento (int nif);
}
