package DSS.GestGestores;

import java.util.HashMap;
import java.util.Map;

public class GestGestoresFacade implements IGestGestoresFacade{

    private Map<String, Gestor> gestores;

    public GestGestoresFacade() {
        this.gestores = new HashMap<>();
    }

    public boolean isAutenticado(String username) {
        if (this.gestores.containsKey(username))
            return this.gestores.get(username).isAutenticado();
        return false;
    }

    public String toString() {
        int i = 1;
        StringBuilder sb = new StringBuilder();
        for (String s : this.gestores.keySet()) {
            sb.append(i).append("- ").append(s).append("\n");
        }
        return sb.toString();
    }

    //Autentica um gestor.
    public boolean autenticaGestor(String username, String password) {
        if (this.gestores.containsKey(username)) {
            return this.gestores.get(username).autenticacao(password);
        }
        return false;
    }

}
