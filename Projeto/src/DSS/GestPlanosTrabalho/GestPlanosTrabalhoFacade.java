package DSS.GestPlanosTrabalho;

import java.util.HashMap;
import java.util.Map;

public class GestPlanosTrabalhoFacade implements IGestPlanosTrabalhoFacade{
    Map<Integer, PlanoTrabalho> planos;

    public GestPlanosTrabalhoFacade () {
        this.planos = new HashMap<>();
    }

    public void adicionaPlano(PlanoTrabalho pt) {
        this.planos.put(pt.getOrcamento().getNif(), pt.clone());
    }

    public PlanoTrabalho obterPlano(int nif) {
        return this.planos.get(nif).clone();
    }


}
