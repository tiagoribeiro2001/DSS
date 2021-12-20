package DSS.GestEquipamentos;

import java.util.HashMap;
import java.util.Map;

public class GestEquipamentosFacade implements IGestEquipamentosFacade {
    Map<Integer, Equipamento> equipamentos;

    public GestEquipamentosFacade (){
        this.equipamentos = new HashMap<>();
    }

    public void insereEquipamento (Equipamento e) {
        this.equipamentos.put(e.getNifCliente(), e.clone());
    }

    public Equipamento obtemEquipamento (int nif) {
        return this.equipamentos.get(nif).clone();
    }

    public boolean existeEquipamento(int nif) {
        return this.equipamentos.containsKey(nif);
    }

    public void removeEquipamento(int nif) {
        this.equipamentos.remove(nif);
    }


}
