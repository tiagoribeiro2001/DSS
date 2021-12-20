package DSS.GestTecnicos;

import java.util.HashMap;
import java.util.Map;

public class GestTecnicosFacade implements IGestTecnicosFacade {

    private Map<String, Tecnico> tecnicos;

    public GestTecnicosFacade () {
        this.tecnicos = new HashMap<>();
    }

    //Autentica um Técnico.
    public boolean autenticaTecnico(String username, String password) {
        if (this.tecnicos.containsKey(username)) {
            return this.tecnicos.get(username).autenticacao(password);
        }
        return false;
    }

    public boolean isAutenticado (String username) {
        return this.tecnicos.get(username).isAutenticado();
    }
}
