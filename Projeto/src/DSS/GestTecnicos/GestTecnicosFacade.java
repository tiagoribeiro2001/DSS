package DSS.GestTecnicos;

import DSS.GestEquipamentos.Equipamento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestTecnicosFacade implements IGestTecnicosFacade {

    private Map<String, Tecnico> tecnicos;

    public GestTecnicosFacade () {
        this.tecnicos = new HashMap<>();
    }

    public Tecnico getTecnico(String username){
        return this.tecnicos.get(username);
    }

    //Autentica um Técnico.
    public boolean autenticaTecnico(String username, String password) {
        if (this.tecnicos.containsKey(username)) {
            return this.tecnicos.get(username).autenticacao(password);
        }
        return false;
    }

    public boolean existe(String username) {
        return this.tecnicos.containsKey(username);
    }

    public List<Equipamento> getEquipamentosReparados(String username) {
        return this.tecnicos.get(username).getEquipamentosReparados();
    }

    public boolean isAutenticado (String username) {
        return this.tecnicos.get(username).isAutenticado();
    }
}
