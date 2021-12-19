package DSS.GestGestores;

import java.util.HashMap;
import java.util.Map;

public class GestGestoresFacade implements IGestGestoresFacade{

    private Map<String, Gestor> gestores;

    public GestGestoresFacade() {
        this.gestores = new HashMap<>();
    }

    //Autentica um gestor.
    public boolean autenticaGestor(String username, String password) {
        if (this.gestores.containsKey(username)) {
            return this.gestores.get(username).autenticacao(password);
        }
        return false;
    }

}
