package DSS.GestEquipamentos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestEquipamentosFacade implements IGestEquipamentosFacade, Serializable {
    Map<Integer, Equipamento> equipamentosNaoReparados;
    Map<Integer, Equipamento> equipamentosReparados;
    Map<Integer, Equipamento> equipamentosNaoReparadosExpresso;

    public GestEquipamentosFacade (){
        this.equipamentosNaoReparados = new HashMap<>();
        this.equipamentosReparados = new HashMap<>();
        this.equipamentosNaoReparadosExpresso = new LinkedHashMap<>();
    }

    public void registaEquipamento (Equipamento e) {
        this.equipamentosNaoReparados.put(e.getNifCliente(), e.clone());
    }

    public void consertaEquipamento (int nif) {
        if (this.equipamentosNaoReparados.containsKey(nif)) {
            this.equipamentosReparados.put(this.equipamentosNaoReparados.get(nif).clone().getNifCliente(), this.equipamentosNaoReparados.get(nif).clone());
            this.equipamentosNaoReparados.remove(nif);
        }
        else if (this.equipamentosNaoReparadosExpresso.containsKey(nif)) {
            this.equipamentosReparados.put(this.equipamentosNaoReparadosExpresso.get(nif).clone().getNifCliente(), this.equipamentosNaoReparadosExpresso.get(nif).clone());
            this.equipamentosNaoReparadosExpresso.remove(nif);
        }
    }

    public void registaEquipamentoExpresso(Equipamento e) {
        this.equipamentosNaoReparadosExpresso.put(e.getNifCliente(), e.clone());
    }

    public Equipamento obtemEquipamento (int nif) {
        if (this.equipamentosNaoReparados.containsKey(nif)) return this.equipamentosNaoReparados.get(nif).clone();
        else if (this.equipamentosReparados.containsKey(nif)) return this.equipamentosReparados.get(nif).clone();
        else if (this.equipamentosNaoReparadosExpresso.containsKey(nif)) return this.equipamentosNaoReparadosExpresso.get(nif).clone();
        else return null;
    }

    public boolean existeEquipamento(int nif) {
        return this.equipamentosNaoReparados.containsKey(nif) || this.equipamentosReparados.containsKey(nif)
                || this.equipamentosNaoReparadosExpresso.containsKey(nif);
    }

    public boolean isNaoReparadosEmpty () {
        return this.equipamentosNaoReparados.isEmpty();
    }

    public boolean isExpressoEmpty() {
        return this.equipamentosNaoReparadosExpresso.isEmpty();
    }

    public void insereCustoReparacao(int nif, double custo) {
        if (this.equipamentosNaoReparados.containsKey(nif)) {
            this.equipamentosNaoReparados.get(nif).adicionaCustoReparacao(custo);
        }
        else if (this.equipamentosNaoReparadosExpresso.containsKey(nif)) {
            this.equipamentosNaoReparadosExpresso.get(nif).adicionaCustoReparacao(custo);
        }
    }


    public double getCustoReparacaoTotal(int nif) {
        if (this.equipamentosReparados.containsKey(nif)) {
            return this.equipamentosReparados.get(nif).getCustoReparacao();
        }
        else return 0.0;
    }

    public boolean estaReparado(int nif) {
        return this.equipamentosReparados.containsKey(nif);
    }


    public Equipamento getExpressoMaisAntigo() {
        return this.equipamentosNaoReparadosExpresso.entrySet().iterator().next().getValue().clone();
    }
    public void removeEquipamento(int nif) {
        if(this.equipamentosNaoReparados.containsKey(nif)) {
            this.equipamentosNaoReparados.remove(nif);
        }
        else if (this.equipamentosReparados.containsKey(nif)) {
            this.equipamentosReparados.remove(nif);
        }
        else if (this.equipamentosNaoReparadosExpresso.containsKey(nif)){
            this.equipamentosNaoReparadosExpresso.remove(nif);
        }
    }


}
