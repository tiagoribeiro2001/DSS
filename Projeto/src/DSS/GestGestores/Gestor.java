package DSS.GestGestores;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Gestor implements Serializable {
    private String username;
    private String password;
    private boolean autenticado;

    public Gestor (String username, String password) {
        this.username = username;
        this.password = password;
        this.autenticado = false;
    }

    public Gestor (Gestor g) {
        this.username = g.getUsername();
        this.password = g.getPassword();
        this.autenticado = g.isAutenticado();
    }

    public String getUsername() {
        return this.username;
    }

    private String getPassword() {
        return this.password;
    }

    public boolean isAutenticado() {
        return this.autenticado;
    }

    public boolean autenticacao (String password) {
        if (this.password.equals(password)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    public Gestor clone() {
        return new Gestor(this);
    }
}

