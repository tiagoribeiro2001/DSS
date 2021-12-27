package DSS.GestOrcamentos;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public interface IGestOrcamentosFacade {
    void addOrcamento (Orcamento o);
    public Orcamento obtemOrcamentoMaisAntigo();
    public void removeOrcamentoMaisAntigo();
    Orcamento getOrcamento (int nif);
}
