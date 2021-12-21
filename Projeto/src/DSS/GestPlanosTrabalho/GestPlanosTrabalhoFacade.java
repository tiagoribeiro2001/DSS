package DSS.GestPlanosTrabalho;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GestPlanosTrabalhoFacade implements IGestPlanosTrabalhoFacade, Serializable {
    Map<Integer, PlanoTrabalho> planos;
    Map<Integer, PlanoTrabalho> planosRealizados;

    public GestPlanosTrabalhoFacade () {
        this.planos = new HashMap<>();
        this.planosRealizados = new HashMap<>();
    }

    public void adicionaPlano(PlanoTrabalho pt) {
        this.planos.put(pt.getOrcamento().getNif(), pt.clone());
    }

    public void adicionaPlanoRealizado(PlanoTrabalho pt) {
        this.planosRealizados.put(pt.getOrcamento().getNif(), pt.clone());
    }

    public PlanoTrabalho obterPlano(int nif) {
        return this.planos.get(nif).clone();
    }

    public PlanoTrabalho obterPlanoRealizado(int nif) {
        return this.planosRealizados.get(nif).clone();
    }

    public int getTempoPasso(int nif, int passo){
        return this.planos.get(nif).getTempo(passo);
    }
}
