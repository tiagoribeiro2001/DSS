package DSS.GestOrcamentos;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Classe GestOrcamentosFacade usada para representar uma coleção de Orcamentos no sistema
 */
public class GestOrcamentosFacade implements IGestOrcamentosFacade, Serializable {
    private LinkedHashMap<Integer, Orcamento> orcamentos;

    public GestOrcamentosFacade(){
        this.orcamentos = new LinkedHashMap<>();
    }

    public void addOrcamento(Orcamento o){
        this.orcamentos.put(o.getNif(), o.clone());
    }

    public Orcamento obtemOrcamentoMaisAntigo(){
        return this.orcamentos.entrySet().iterator().next().getValue().clone();
    }

    public void removeOrcamentoMaisAntigo(){
        this.orcamentos.remove(this.orcamentos.entrySet().iterator().next().getKey());
    }

    public Orcamento getOrcamento(int nif){
        return this.orcamentos.get(nif);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Lista de reparações necessárias:\n");
        sb.append("-------------------------------------\n");
        this.orcamentos.values().forEach(j -> sb.append(j.toString()).append("-------------------------------------\n"));
        return sb.toString();
    }
}
