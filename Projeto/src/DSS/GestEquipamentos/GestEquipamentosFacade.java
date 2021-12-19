package DSS.GestEquipamentos;

import java.util.HashMap;
import java.util.Map;

public class GestEquipamentosFacade {
    Map<Integer, Equipamento> equipamentos;

    public GestEquipamentosFacade (){
        this.equipamentos = new HashMap<>();
    }

    public void insereEquipamento (Equipamento e) {
        this.equipamentos.put(e.getNifCliente(), e.clone());
    }


}
