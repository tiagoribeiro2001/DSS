package DSS.GestFuncionarios;
import DSS.GestEquipamentos.Equipamento;
import DSS.GestTecnicos.Tecnico;
import java.io.Serializable;

/**
 * Classe Funcionario usada para representar um funcionário de balcão presente no sistema
 */
public class Funcionario implements Serializable {

    private String username;
    private String password;
    private int recepcoes;
    private int entregas;
    private boolean autentificacao;
    //private boolean disponivel;

    /**
     * Construtor parametrizado da classe Funcionario
     */
    public Funcionario(String username, String password){
        this.username = username;
        this.password = password;
        this.recepcoes = 0;
        this.entregas = 0;
        this.autentificacao = false;
    }

    /**
     * Contrutor clone da classe Funcionario
     * @param f Funcionario a ser copiado
     */
    public Funcionario(Funcionario f){
        this.username = f.getUsername();
        this.password = f.getPassword();
        this.recepcoes = f.getRecepcoes();
        this.entregas = f.getEntregas();
        this.autentificacao = false;
    }

    /**
     * Método getter do username do Funcionario
     * @return Username do Funcionario
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Método getter da password do Funcionario
     * @return Password do Funcionario
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Método getter do número de recepções de equipamentos efetuados pelo Funcionario
     * @return Número de recepções
     */
    public int getRecepcoes(){
        return this.recepcoes;
    }

    /**
     * Método getter do número de entregas de equipamentos efetuados pelo Funcionario
     * @return Número de entregas
     */
    public int getEntregas(){
        return this.entregas;
    }

    /**
     * Método que verifica se um Funcionario está autenticado
     * @return Booleano que indica se o funcionário está autenticado
     */
    public boolean isAutenticado(){
        return autentificacao;
    }

    /**
     * Método que efetua a autenticação do Funcionario
     * @param password Password do Funcionario
     * @return Booleano que infica se foi efetuada a autenticação com sucesso
     */
    public boolean autentificacao(String password){
        if (this.password.equals(password)) {
            this.autentificacao = true;
            return true;
        }
        return false;
    }

    /**
     * Método que incrementa o número de recepções de equipamentos de um Funcionario
     */
    public void incRecepcoes(){
        this.recepcoes = this.recepcoes + 1;
    }

    /**
     * Método que incrementa o número de entregas de equipamentos de um Funcionario
     */
    public void incEntregas(){
        this.entregas = this.entregas + 1;
    }

    /**
     * Método toString da classe Funcionario
     * @return String do Funcionario
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Funcionario {\n");
        sb.append("\tUsername - ").append(username).append("\n");
        sb.append("\tRecepcoes - ").append(recepcoes).append("\n");
        sb.append("\tEntregas - ").append(recepcoes).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Método clone da classe Funcionario
     * @return Funcionario clonado
     */
    public Funcionario clone(){
        return new Funcionario(this);
    }
}
