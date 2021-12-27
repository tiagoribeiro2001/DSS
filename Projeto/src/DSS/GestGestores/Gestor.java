package DSS.GestGestores;

import java.io.Serializable;

/**
 * Classe Gestor usada para representar um gestor presente no sistema
 */
public class Gestor implements Serializable {
    private String username;
    private String password;
    private boolean autenticado;

    /**
     * Construtor parametrizado da classe Gestor
     * @param username
     * @param password
     */
    public Gestor(String username, String password){
        this.username = username;
        this.password = password;
        this.autenticado = false;
    }

    /**
     * Contrutor clone da classe Gestor
     * @param g Gestor a ser copiado
     */
    public Gestor(Gestor g){
        this.username = g.getUsername();
        this.password = g.getPassword();
        this.autenticado = g.isAutenticado();
    }

    /**
     * Método getter do username do Gestor
     * @return Username do Gestor
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Método getter da password do Gestor
     * @return Password do Gestor
     */
    private String getPassword(){
        return this.password;
    }

    /**
     * Método que verifica se un Gestor está autenticado
     * @return Booleano que indica se se o Gestor está autenticado
     */
    public boolean isAutenticado(){
        return this.autenticado;
    }

    /**
     * Método que efetua a autenticação do Gestor
     * @param password Password do Gestor
     * @return Booleano que infica se foi efetuada a autenticação com sucesso
     */
    public boolean autenticacao(String password){
        if (this.password.equals(password)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    /**
     * Método clone da classe Gestor
     * @return Gestor clonado
     */
    public Gestor clone() {
        return new Gestor(this);
    }
}

