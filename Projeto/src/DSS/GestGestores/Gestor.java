package DSS.GestGestores;

import java.util.HashMap;
import java.util.Map;

public class Gestor {
    private String username;
    private String password;
    private boolean autenticado;

    public boolean autenticacao (String password) {
        if (this.password.equals(password)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }
}

