package DSS.GestPlanosTrabalho;

import DSS.GestEquipamentos.Equipamento;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe GestPlanosTrabalhoFacade usada para representar uma coleção de planos de trabalho no sistema
 */
public class GestPlanosTrabalhoFacade implements IGestPlanosTrabalhoFacade, Serializable{
    Map<Integer, PlanoTrabalho> planos;
    Map<Integer, PlanoTrabalho> planosRealizados;

    public GestPlanosTrabalhoFacade () {
        this.planos = new HashMap<>();
        this.planosRealizados = new HashMap<>();
    }

    public void criaPlano(Equipamento e){
        this.planos.put(e.getNifCliente(), new PlanoTrabalho(e));
    }

    public void criaPlanoRealizado(Equipamento e){
        this.planosRealizados.put(e.getNifCliente(), new PlanoTrabalho(e));
    }

    public void adicionaPlano(PlanoTrabalho pt) {
        this.planos.put(pt.getOrcamento().getNif(), pt.clone());
    }

    public void adicionaPlanoRealizado(PlanoTrabalho pt) {
        this.planosRealizados.put(pt.getOrcamento().getNif(), pt.clone());
    }

    public void adicionaPassoToPlano(int nif, String passo, double custo, int tempo){
        this.planos.get(nif).adicionaPasso(passo,custo, tempo);
    }

    public void adicionaPassoToPlanoRealizado(int nif, String passo, double custo, int tempo){
        this.planosRealizados.get(nif).adicionaPasso(passo,custo, tempo);
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
