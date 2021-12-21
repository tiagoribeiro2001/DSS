package DSS.GestFuncionarios;
import DSS.GestEquipamentos.Equipamento;
import DSS.GestTecnicos.Tecnico;

public class Funcionario {

    private String username;
    private String password;
    private int recepcoes;
    private int entregas;
    private boolean autentificacao;
    //private boolean disponivel;

    //Construtor Funcioario
    public Funcionario (String username, String password) {
        this.username = username;
        this.password = password;
        this.recepcoes = 0;
        this.entregas = 0;
        this.autentificacao = false;
    }

    //Construtor a partir de objeto
    public Funcionario (Funcionario f) {
        this.username = f.getUsername();
        this.password = f.getPassword();
        this.recepcoes = f.getRecepcoes();
        this.entregas = f.getEntregas();
        this.autentificacao = false;
    }

    //Obtem username
    public String getUsername() {
        return this.username;
    }

    //Obtem password (apenas acessível pela própria classe).
    private String getPassword () {
        return this.password;
    }

    //Obtem o número de recepcoes de equipamentos feitos pelo funcionario
    public int getRecepcoes(){
        return this.recepcoes;
    }

    //Obtem o número de entregas de equipamentos feitos pelo funcionario
    public int getEntregas(){
        return this.entregas;
    }

    public boolean isAutenticado () {return autentificacao;}

    //Autentificação funcionário.
    public boolean autentificacao (String password) {
        if (this.password.equals(password)) {
            this.autentificacao = true;
            return true;
        }
        return false;
    }

    public void regista_equipamento(Equipamento e, Tecnico tecnico){
        // metodo que dado um equipamento regista-o no sistema
    }

    public void sem_confirmacao(Equipamento e){
        //Se cliente não deu confirmação de orçamento por mais de 30 dias, orçamento é arquivado
    }

    public void incRecepcoes(){
        this.recepcoes = this.recepcoes + 1;
    }

    public void incEntregas(){
        this.entregas = this.entregas + 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Funcionario {\n");
        sb.append("\tUsername - ").append(username).append("\n");
        sb.append("\tRecepcoes - ").append(recepcoes).append("\n");
        sb.append("\tEntregas - ").append(recepcoes).append("\n");
        sb.append("}");
        return sb.toString();
    }

    public Funcionario clone () {
        return new Funcionario(this);
    }
}
