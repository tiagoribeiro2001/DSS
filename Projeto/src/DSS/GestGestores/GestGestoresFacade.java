package DSS.GestGestores;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.GestFuncionarios.Funcionario;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GestGestoresFacade implements IGestGestoresFacade, Serializable {

    private Map<String, Gestor> gestores;

    public GestGestoresFacade() {
        this.gestores = new HashMap<>();
    }

    public boolean isAutenticado(String username) {
        if (this.gestores.containsKey(username))
            return this.gestores.get(username).isAutenticado();
        return false;
    }

    public void registaGestor(Gestor g) {
        this.gestores.put(g.getUsername(), g.clone());
    }

    public boolean registaGestor(Funcionario f) {
        if (!this.gestores.containsKey(f.getUsername())) {
            Gestor g = new Gestor(f.getUsername(), f.getPassword());
            this.gestores.put(g.getUsername(), g.clone());
            return true;
        }
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
    public boolean autenticaGestor(String username, String password) throws CredenciaisInvalidasException {
        if (this.gestores.containsKey(username)) {
            if (this.gestores.get(username).autenticacao(password))
                return true;
        }
        throw new CredenciaisInvalidasException ("Erro: Credenciais inseridas são inválidas.");
    }

}
